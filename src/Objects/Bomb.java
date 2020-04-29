package Objects;

import Logic.Images;

public class Bomb extends FallenObject{

    public Bomb() {
        super(Images.BOMB);
    }

    public int getFallLive(boolean capture){
        return (capture ? -3 : 0);
    }

    public int getFallPoint(boolean capture){
        return 0;
    }

}
