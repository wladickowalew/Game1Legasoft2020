package Objects;

import Logic.Variables;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static Logic.Variables.BOTTOM_MARGIN;
import static Logic.Variables.H;

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
        fallTimer.start();
    }

    private int randInt(int a, int b){
        return (int)(a + Math.random() * (b - a));
    }

    public boolean isFall(){
        return getY() + Variables.IMAGE_SIZE >= H - BOTTOM_MARGIN;
    }

    public int getFallLive(boolean capture){
        return 0;
    }

    public int getFallPoint(boolean capture){
        return 0;
    }

}
