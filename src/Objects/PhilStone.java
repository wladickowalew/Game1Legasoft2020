package Objects;

import Logic.Images;

import java.awt.*;

public class PhilStone extends FallenObject {

    protected int mint = 10;
    protected int maxt = 30;

    public PhilStone() {
        super(Images.PHIL_STONE);
    }

    public int getFallLive(boolean capture){
        //if (capture) {
        //    return 0;
        //}else{
        //    return -1
        //}
        return (capture ? 10: 0);
    }

    public int getFallPoint(boolean capture){
        return (capture ? -100: 1);
    }
}
