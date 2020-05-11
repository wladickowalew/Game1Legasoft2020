package Objects;

import Logic.Images;

public class DreamMaker extends FallenObject {

    public DreamMaker() {
        super(Images.DREAM_MAKER);
    }

    public int getFallLive(boolean capture){
        //if (capture) {
        //    return 0;
        //}else{
        //    return -1
        //}
        return (capture ? - 10: 1);
    }

    public int getFallPoint(boolean capture){
        return (capture ? 100 : -5);
    }
}
