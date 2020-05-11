package Objects;

import Logic.Images;

public class FirstAid extends FallenObject {

    public FirstAid() {
        super(Images.FIRST_AID);
    }

    public int getFallLive(boolean capture){
        //if (capture) {
        //    return 0;
        //}else{
        //    return -1
        //}
        return (capture ? 2: 0);
    }

    public int getFallPoint(boolean capture){
        return (capture ? 0 : 0);
    }
}


