package Logic;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Images {

    public static Image FONE, END;
    public static Image CATCHER;
    public static Image SIMPLE_ENEMY;
    public static Image BOMB;
    public static Image FIRST_AID;
    public static Image SIDOR;
    public static Image CASE;
    public static Image THIEF;
    public static Image PHIL_STONE;
    public static Image DREAM_MAKER;
    public static Image BLOOD_SUCKER;

    public static void  loadImages(){
        try {
            CATCHER = ImageIO.read(new File("data/images/catcher.png"));
            FONE = ImageIO.read(new File("data/images/fone.png"));
            END = ImageIO.read(new File("data/images/end.jpg"));
            SIMPLE_ENEMY = ImageIO.read(new File("data/images/enemy.png"));
            BOMB = ImageIO.read(new File("data/images/bomb.png"));
            FIRST_AID = ImageIO.read(new File("data/images/aid.png"));
            SIDOR = ImageIO.read(new File("data/images/sidor(jkh).png"));
            CASE = ImageIO.read(new File("data/images/case.png"));
            THIEF = ImageIO.read(new File("data/images/thief.png"));
            PHIL_STONE = ImageIO.read(new File("data/images/phil_stone.png"));
            DREAM_MAKER = ImageIO.read(new File("data/images/dream_maker.png"));
            BLOOD_SUCKER = ImageIO.read(new File("data/images/blood_sucker.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
