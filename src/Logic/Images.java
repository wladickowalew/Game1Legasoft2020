package Logic;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Images {

    public static Image FONE, END;
    public static Image CATCHER;
    public static Image SIMPLE_ENEMY, BOMB;

    public static void  loadImages(){
        try {
            CATCHER      = ImageIO.read(new File("data/images/catcher.png"));
            FONE         = ImageIO.read(new File("data/images/fone.jpg"));
            END          = ImageIO.read(new File("data/images/end.jpg"));
            SIMPLE_ENEMY = ImageIO.read(new File("data/images/enemy.png"));
            BOMB         = ImageIO.read(new File("data/images/bomb.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
