package Objects;

import Logic.Images;
import Logic.Variables;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

import static Logic.Variables.*;

public class Catcher extends Player {

    public Catcher (){
        super(Images.CATCHER, (Variables.W - IMAGE_SIZE)/2, H - BOTTOM_MARGIN);
    }

    public boolean catchObject(Player obj){
        return  Math.abs(this.getX() - obj.getX()) <  CATCH_RADIUS;
    }

    public void move(int dx){
        int p = this.getX() + dx;
//        if (p > Variables.W - 50) {
//            p = -50;
//        } else {
//            if (p < -50)
//                p = Variables.W - 50;
//        }
        if (p > Variables.W - IMAGE_SIZE) p = -IMAGE_SIZE;
        else if (p < -IMAGE_SIZE) p = Variables.W - IMAGE_SIZE;
        this.setX(p);
    }

}
