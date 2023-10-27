package com.wb;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BackGround {
    //当前场景要显示的图像
    private BufferedImage bgImage = null;

    private List<Obstacle> obstacleList = new ArrayList<>();

    private Zombies zombies;


    private List<Pea> peaList = new ArrayList<>();
    public BackGround() {

    }

    public BackGround(boolean flag) {

        bgImage = StaticValue.bg;
        for(int i = 0;i < 5;i++) {
            obstacleList.add(new Obstacle(260, 90+i*100, this));
        }
        zombies = new Zombies(900,50);
    }

    public BufferedImage getBgImage() {
        return bgImage;
    }

    public List<Obstacle> getObstacleList() {
        return obstacleList;
    }

    public void setObstacleList(List<Obstacle> obstacleList) {
        this.obstacleList = obstacleList;
    }

    public Zombies getZombies() {
        return zombies;
    }
    public List<Pea> getPeaList() {
        return peaList;
    }
}
