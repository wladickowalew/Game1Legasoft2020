package Logic;

import Objects.*;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Field extends JPanel {

    private Catcher cat;
    private ArrayList<FallenObject> objects = new ArrayList<>();
    private Timer paintTimer, updateTimer;
    private int lives, points, level;
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
    }

    private void showInfo(){
        System.out.println("Level: " + level + " Points: " + points + " Lives: " + lives);
    }

    private void update(){
        double p = 0.3;
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
    }

    public void catLeft(){ cat.move(-Variables.STEP); }
    public void catRight(){ cat.move(Variables.STEP); }

    private void endGame(){
        updateTimer.stop();
        paintTimer.stop();
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
