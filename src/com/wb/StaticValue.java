package com.wb;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StaticValue {
    //背景
    public static BufferedImage bg = null;
    //加载植物
    public static List<BufferedImage> plants =new ArrayList<>();
    //加载僵尸
    public static BufferedImage zombies = null;
    //路径的前缀,方便后续调用
    public static String path = System.getProperty("user.dir") + "/src/images/";

    //初始化方法
    public static void init() {
        try {
            //加载背景图片
            bg = ImageIO.read(new File(path + "bg.jpg"));
            plants.add(ImageIO.read(new File(path + "pease.gif")));
            plants.add(ImageIO.read(new File(path + "pea.png")));
            zombies = ImageIO.read(new File(path + "zombie1.gif"));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
