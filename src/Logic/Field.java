package Logic;

import GUI.GameLabel;
import Objects.*;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.logging.Level;

public class Field extends JPanel {

    private Catcher cat;
    private ArrayList<FallenObject> objects = new ArrayList<>();
    private Timer paintTimer, updateTimer, levelTimer;
    private int lives, points, level;
    private GameLabel liveslbl, pointslbl, levellbl;
    private boolean is_end;

    public Field(int w, int h){
        Variables.W = w;
        Variables.H = h;
        Images.loadImages();
        cat = new Catcher();
        createTimers();
        lives = 3;
        points = 0;
        level = 1;
        is_end = false;
        addLabels();
    }

    private void addLabels(){
        setLayout(null);
        levellbl = new GameLabel("Level", level);
        levellbl.setLocation(10,10);
        this.add(levellbl);

        liveslbl = new GameLabel("Lives", lives);
        liveslbl.setLocation(220,10);
        this.add(liveslbl);

        pointslbl = new GameLabel("Points", points);
        pointslbl.setLocation(430,10);
        this.add(pointslbl);
    }

    private void updateLabels(){
        levellbl.change(level);
        liveslbl.change(lives);
        pointslbl.change(points);
    }

    private void showInfo(){
        System.out.println("Level: " + level + " Points: " + points + " Lives: " + lives);
    }

    private void update(){
        double d = (Variables.MAX_OBJECT_P - Variables.MIN_OBJECT_P)/(Variables.MAX_LEVEL - 1);
        System.out.println("level = "+level + " p = " + (Variables.MIN_OBJECT_P + (level - 1) * d));
        double p = Variables.MIN_OBJECT_P + (level - 1) * d;
        if (Math.random() < p)
            addObject();
        checkFall();
        if (lives == 0)
            endGame();
    }

    private void checkFall(){
        for (int i = 0; i < objects.size(); i++){
            if (objects.get(i).isFall()){
                fallObject(objects.get(i));
                objects.remove(i);
            }
        }
    }

    private void fallObject(FallenObject object){
        boolean capture = cat.catchObject(object);
        lives  += object.getFallLive(capture);
        points += object.getFallPoint(capture);
        if (lives < 0) lives = 0;
        if (points < 0) points = 0;
        showInfo();
        updateLabels();
    }

    private void addObject(){
        double p = Math.random();
        if (p < 0.8){
            objects.add(new SimpleEnemy());
        }else{
            objects.add(new Bomb());
        }
    }

    private void createTimers(){
        paintTimer = new Timer(50, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                repaint();
            }
        });
        paintTimer.start();
        updateTimer = new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                update();
            }
        });
        updateTimer.start();
        levelTimer = new Timer(Variables.LEVEL_UPDATE * 1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (level < Variables.MAX_LEVEL)
                    level++;
                updateLabels();
            }
        });
        levelTimer.start();
    }

    public void catLeft(){ cat.move(-Variables.STEP); }
    public void catRight(){ cat.move(Variables.STEP); }

    private void endGame(){
        updateTimer.stop();
        paintTimer.stop();
        levelTimer.stop();
        is_end = true;
        repaint();
    }

    //paint all

    private void paintObjects(Graphics g){
        cat.draw(g);
        for (FallenObject object: objects){
            object.draw(g);
        }
        if (is_end){
            int x = (Variables.W - Variables.END_IMAGE_W)/2;
            int y = (Variables.H - Variables.END_IMAGE_H)/2;
            g.drawImage(Images.END, x, y, Variables.END_IMAGE_W, Variables.END_IMAGE_H, null);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(Images.FONE,0,0, Variables.W, Variables.H, null);
        paintObjects(g);
    }
}
