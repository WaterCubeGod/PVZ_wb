package com.wb;

import java.awt.image.BufferedImage;
import java.util.Random;
import java.math.*;

public class Pea implements Runnable{
    private int x;
    private int y;
    private int xSpeed;
    private int ySpeed;
    private BufferedImage show;
    private BackGround bg = new BackGround();

    Thread thread = new Thread(this);

    public Pea(){

    }
    public Pea(int x,int y,BackGround bg){
        this.x = x;
        this.y = y;
        this.bg = bg;
        show = StaticValue.plants.get(1);
        thread.start();
    }
    //获取速度
    public void speed(){

    }

    public void death(){
        bg.getPeaList().remove(this);
    }

    @Override
    public void run() {
        int count = 0;
        while(true){
            if(count == 0) {
                Random random = new Random();
                xSpeed = (random.nextInt(2) + 1) * 5;
                int k = random.nextInt(2);
                if (k == 1) {
                    ySpeed = (random.nextInt(2) + 1) * 5;
                } else {
                    ySpeed = -(random.nextInt(2) + 1) * 5;
                }
                count ++;
            }
            x += xSpeed;
            y += ySpeed;

            show = StaticValue.plants.get(1);

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public BufferedImage getShow() {
        return show;
    }
}
