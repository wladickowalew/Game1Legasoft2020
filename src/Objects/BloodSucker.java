package Objects;

import Logic.Images;

import java.awt.*;

public class BloodSucker extends FallenObject {

    public BloodSucker() {
        super(Images.BLOOD_SUCKER);
    }
    public int getFallLive(boolean capture){
        //if (capture) {
        //    return 0;
        //}else{
        //    return -1
        //}
        return (capture ? - 1000000: 0);
    }

    public int getFallPoint(boolean capture){
        return (capture ? 0 : 0);
    }
}
