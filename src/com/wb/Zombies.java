package com.wb;

import javax.swing.*;
import java.awt.image.BufferedImage;

public class Zombies implements Runnable{

    private int x;
    private int y;

    private boolean flag = false;

    private boolean isDeath =false;
    private int xSpeed = 0;
    private int ySpeed = 0;
    private BufferedImage show;


    private String status;

    public void setBg(BackGround bg) {
        this.bg = bg;
    }

    private BackGround bg = new BackGround();
    private Thread thread;

    public Zombies(){
    }
    public Zombies(int x, int y){
        this.x = x;
        this.y = y;
        show = StaticValue.zombies;
        thread = new Thread(this);
        thread.start();
    }

    //死亡方法
    public void death(){
        isDeath = true;
    }
    //移动
    public void leftMove() {
        xSpeed = -5;
        status = "left";
    }

    public void rightMove() {
        xSpeed = 5;
        status = "right";
    }

    public void upMove(){
        ySpeed = -5;
        status = "up";
    }

    public void downMove(){
        ySpeed = 5;
        status = "down";
    }

    //停止
    public void xyStop() {
        xSpeed = 0;
            status = "stop";
    }
    public void zStop() {
        ySpeed = 0;
        status = "stop";
    }

    //判断僵尸是否被豌豆砸中
    public void isPea(BackGround bg){
        for(int i = 0;i < bg.getPeaList().size();i++){
            Pea p = bg.getPeaList().get(i);
            if((p.getX() < this.x + 55 && p.getY() > this.y - 28) &&
                    (p.getX() > this.x && p.getY() < this.y + 100)){
                this.death();
                this.show = null;
            }
        }
    }

    @Override
    public void run() {
        while(true){
            if(xSpeed != 0 || ySpeed != 0) {
                x += xSpeed;
                y += ySpeed;
                if(x > 1000){
                    x = 1000;
                }
                if(y < 0){
                    y = 0;
                }
                if(y > 550){
                    y = 550;
                }
                if(x <= 200){
                    x = 200;
                    flag = true;
                }
            }

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

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public int getxSpeed() {
        return xSpeed;
    }

    public void setxSpeed(int xSpeed) {
        this.xSpeed = xSpeed;
    }

    public int getySpeed() {
        return ySpeed;
    }

    public void setySpeed(int ySpeed) {
        this.ySpeed = ySpeed;
    }

    public boolean isDeath() {
        return isDeath;
    }
}
