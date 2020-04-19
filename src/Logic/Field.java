package Logic;

import Objects.Catcher;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Field extends JPanel {

    private Catcher cat;
    private Timer paintTimer;

    public Field(int w, int h){
        Variables.W = w;
        Variables.H = h;
        Images.loadImages();
        cat = new Catcher(h, w);
        createTimers();
    }

    private void createTimers(){
        paintTimer = new Timer(50, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                repaint();
            }
        });
        paintTimer.start();
    }

    public void catLeft(){ cat.move(-Variables.STEP); }
    public void catRight(){ cat.move(Variables.STEP); }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(Images.FONE,0,0, null);
        cat.draw(g);
    }
}
