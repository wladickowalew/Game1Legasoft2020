package GUI;

import javax.swing.*;
import java.awt.*;

public class GameLabel extends JLabel {

    private String text;

    public GameLabel(String text, int number){
        super(text + ": " + number);
        this.text = text;
        setForeground(Color.WHITE);
        Font f = new Font("Comic Sans MS", 0, 24);
        setFont(f);
        setSize(200,30);
    }

    public void change(int number){
        setText(text + ": " + number);
    }

}
