package Objects;

import Logic.Variables;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FallenObject extends Player{

    private Timer fallTimer;

    public FallenObject(Image img) {
        super(img, 0, 0);
        setY(-100);
        setX(randInt(0, Variables.W - img.getWidth(null)));
        fallTimer = new Timer(50, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setY(getY() + 2);
            }
        });
    }

    private int randInt(int a, int b){
        return (int)(a + Math.random() * (b - a));
    }

}
