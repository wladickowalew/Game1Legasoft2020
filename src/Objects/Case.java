package Objects;

import Logic.Images;

public class Case extends FallenObject{

    public Case() {
        super(Images.CASE);
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
        return (capture ? 10 : 0);
    }
}
