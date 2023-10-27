package com.wb;

import java.awt.image.BufferedImage;

public class Obstacle {
    //用于表示坐标
    private int x;
    private int y;
    //用于记录类型
    private int type;

    //用于显示图像
    private BufferedImage show = null;
    //定义当前的场景对象
    private BackGround bg = null;

    public Obstacle(int x, int y, BackGround bg) {
        this.x = x;
        this.y = y;
        this.type = type;
        this.bg = bg;
        show = StaticValue.plants.get(0);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getType() {
        return type;
    }

    public BufferedImage getShow() {
        return show;
    }

    //植物死亡
    public void death(){
        this.bg.getObstacleList().remove(this);
    }

}
