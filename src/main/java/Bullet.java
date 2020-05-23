import lombok.Data;

import java.awt.*;

@Data
public class Bullet {

    private static final int SPEED = 10;

    public static int WIDTH = 10;

    public static int HEIGHT = 10;

    private int x;

    private int y;

    private Dir dir;

    private TankFrame tf = null;

    public Bullet(int x, int y, Dir dir, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
    }

    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.YELLOW);
        g.fillOval(x, y, WIDTH, HEIGHT);
        g.setColor(c);
        move();
    }

    private void move() {

        switch (dir) {
            case LEFT:
                x -= SPEED;
                break;
            case UP:
                y -= SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
            case DOWN:
                y += SPEED;
                break;
        }
        if (x < 0 || y < 0 || x > TankFrame.GAME_HEIGHT || y > TankFrame.GAME_HEIGHT) {
            this.tf.bullets.remove(this);
        }
    }
}
