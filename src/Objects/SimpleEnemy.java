package Objects;

import Logic.Images;

public class SimpleEnemy extends FallenObject{

    public SimpleEnemy() {
        super(Images.SIMPLE_ENEMY);
    }

    public int getFallLive(boolean capture){
        return (capture ? 0 : -1);
    }

    public int getFallPoint(boolean capture){
        return (capture ? 1 : 0);
    }
}
