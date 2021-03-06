package Objects;

import java.awt.*;

import static Logic.Variables.*;

public class Player {
    private Image img;
    private int x, y;

    public Player(Image img, int x, int y) {
        this.img = img;
        this.x = x;
        this.y = y;
    }

    public Image getImg() {
        return img;
    }

    public void setImg(Image img) {
        this.img = img;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) { this.x = x; }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void draw(Graphics g){
        g.drawImage(img, x, y, IMAGE_SIZE, IMAGE_SIZE, null);
    }
}
