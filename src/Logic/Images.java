package Logic;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Images {

    public static Image FONE;
    public static Image CATCHER;

    public static void  loadImages(){
        try {
            CATCHER = ImageIO.read(new File("data/images/catcher.png"));
            FONE = ImageIO.read(new File("data/images/fone.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
