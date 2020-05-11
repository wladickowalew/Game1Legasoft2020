package Objects;

import Logic.Images;

import java.awt.*;

public class Theif extends FallenObject{

    public Theif() {
        super(Images.THIEF);
    }

    public int getFallLive(boolean capture){
        //if (capture) {
        //    return 0;
        //}else{
        //    return -1
        //}
        return (capture ? 0: 0);
    }

    public int getFallPoint(boolean capture){
        return (capture ? -2: -10);
    }
}
