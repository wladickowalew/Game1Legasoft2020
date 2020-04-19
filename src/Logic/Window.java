package Logic;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Window extends JFrame {

    private int W;
    private int H;
    private Field field;

    private class MyKeyListener implements KeyListener {

        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            int code = e.getKeyCode();
            switch (code){
                case 37:
                    field.catLeft();
                    break;
                case 39:
                    field.catRight();
                    break;
                case 27:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Tapped on: " + code);
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }

    public Window(int w, int h){
        this.W = w;
        this.H = h;
        addKeyListener(new MyKeyListener());
        setFocusable(true);
        setTitle("My Game");
        setResizable(false);
        setBounds(0,0, w, h);
        field = new Field(w, h);
        getContentPane().add(field);
        setVisible(true);
    }
}
