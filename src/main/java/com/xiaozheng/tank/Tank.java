package com.xiaozheng.tank;

import lombok.Data;

import java.awt.*;

@Data
public class Tank {

    private static final int SPEED = 10;

    private int x;

    private int y;

    private Dir dir;

    private boolean moving = false;

    private TankFrame tf = null;

    public Tank(int x, int y, Dir dir, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
    }

    public void paint(Graphics g) {
        switch (dir) {
            case LEFT:
                g.drawImage(ResourceMgr.tankL, x, y, null);
                break;
            case RIGHT:
                g.drawImage(ResourceMgr.tankR, x, y, null);
                break;
            case UP:
                g.drawImage(ResourceMgr.tankU, x, y, null);
                break;
            case DOWN:
                g.drawImage(ResourceMgr.tankD, x, y, null);
                break;

        }

        move();
    }

    private void move() {
        if (!moving) return;
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
    }


    public void shut() {
        int bX = 0;
        int bY = 0;
        switch (dir) {
            case LEFT:
                bX = this.x + ResourceMgr.tankL.getWidth() / 2 - ResourceMgr.bulletL.getWidth() / 2;
                bY = this.y + ResourceMgr.tankL.getHeight() / 2 - ResourceMgr.bulletL.getHeight() / 2;
                break;
            case UP:
                bX = this.x + ResourceMgr.tankU.getWidth() / 2 - ResourceMgr.bulletU.getWidth() / 2;
                bY = this.y + ResourceMgr.tankU.getHeight() / 2 - ResourceMgr.bulletU.getHeight() / 2;
                break;
            case RIGHT:
                bX = this.x + ResourceMgr.tankR.getWidth() / 2 - ResourceMgr.bulletR.getWidth() / 2;
                bY = this.y + ResourceMgr.tankR.getHeight() / 2 - ResourceMgr.bulletR.getHeight() / 2;
                break;
            case DOWN:
                bX = this.x + ResourceMgr.tankD.getWidth() / 2 - ResourceMgr.bulletD.getWidth() / 2;
                bY = this.y + ResourceMgr.tankD.getHeight() / 2 - ResourceMgr.bulletD.getHeight() / 2;
                break;
        }

        tf.bullets.add(new Bullet(bX, bY, this.dir, this.tf));
    }
}
