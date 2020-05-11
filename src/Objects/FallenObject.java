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
    protected int mint = 30;
    protected int maxt = 60;

    public FallenObject(Image img) {
        super(img, 0, 0);
        setY(-100);
        setX(randInt(0, Variables.W - img.getWidth(null)));
        int dx = randInt(1,4);
        double k = 1 - Variables.level / Variables.MAX_LEVEL;
        int t = mint + (int) (k * randInt(0, maxt - mint));

        fallTimer = new Timer(t, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setY(getY() + dx);
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
