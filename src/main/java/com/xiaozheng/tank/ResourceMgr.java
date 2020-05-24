package com.xiaozheng.tank;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ResourceMgr {
    public static BufferedImage tankL, tankU, tankR, tankD;

    public static BufferedImage bulletL, bulletU, bulletR, bulletD;

    static {
        try {
            tankL = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("tankL.gif"));
            tankU = ImageIO.read(com.xiaozheng.tank.ResourceMgr.class.getClassLoader().getResourceAsStream("tankU.gif"));
            tankR = ImageIO.read(com.xiaozheng.tank.ResourceMgr.class.getClassLoader().getResourceAsStream("tankR.gif"));
            tankD = ImageIO.read(com.xiaozheng.tank.ResourceMgr.class.getClassLoader().getResourceAsStream("tankD.gif"));

            bulletL = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("bulletL.gif"));
            bulletR = ImageIO.read(com.xiaozheng.tank.ResourceMgr.class.getClassLoader().getResourceAsStream("bulletR.gif"));
            bulletU = ImageIO.read(com.xiaozheng.tank.ResourceMgr.class.getClassLoader().getResourceAsStream("bulletU.gif"));
            bulletD = ImageIO.read(com.xiaozheng.tank.ResourceMgr.class.getClassLoader().getResourceAsStream("bulletD.gif"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
