package Objects;

import Logic.Images;

public class Sidor extends FallenObject{

    public Sidor() {
        super(Images.SIDOR);
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
        return (capture ? -20 : -1000000);
    }

}
