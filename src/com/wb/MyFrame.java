package com.wb;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class MyFrame extends JFrame implements KeyListener,Runnable {

        private BackGround nowBg = new BackGround();

        private Zombies zombie = new Zombies();
        private int count = 0;
        //用于双缓存
        private Image offScreenImage = null;
        private Thread thread = new Thread(this);
        public MyFrame() {
                //设置窗口的大小为1000 * 600
                this.setSize(1000,600);
                //设置窗口居中显示
                this.setLocationRelativeTo(null);
                //设置窗口的可见性
                this.setVisible(true);
                //设置点击窗口上的关闭键,结束程序
                this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                //设置窗口大小不可变
                this.setResizable(false);
                //向窗口对象添加键盘监听器
                this.addKeyListener(this);
                //设置窗口名称
                this.setTitle("植物大战僵尸");

                //初始化图片
                StaticValue.init();
                //僵尸
                zombie = new Zombies(900,150);
                nowBg = new BackGround(true);
                zombie.setBg(nowBg);
                //绘制图像
                repaint();
                thread.start();
        }

        @Override
        public void paint(Graphics g) {
                if (offScreenImage == null) {
                        offScreenImage = createImage(1000,600);
                }

                Graphics graphics = offScreenImage.getGraphics();
                graphics.fillRect(0,0,1000,600);

                //绘制背景
                graphics.drawImage(nowBg.getBgImage(),0,0,this);
                //绘制图像
                for (Obstacle ob : nowBg.getObstacleList()) {
                        graphics.drawImage(ob.getShow(),ob.getX(),ob.getY(),this);
                }
                graphics.drawImage(zombie.getShow(),zombie.getX(),zombie.getY(),this);

                graphics.drawImage(zombie.getShow(),zombie.getX(),zombie.getY(),this);
                //绘制豌豆
                for(Pea p : nowBg.getPeaList()){
                        graphics.drawImage(p.getShow(),p.getX(),p.getY(),this);
                }
                //将图像绘制到窗口中
                g.drawImage(offScreenImage,0,0,this);
        }


        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == 39) {
                        zombie.rightMove();
                }
                if (e.getKeyCode() == 37) {
                        zombie.leftMove();
                }
                if (e.getKeyCode() == 38) {
                        zombie.upMove();
                }
                if (e.getKeyCode() == 40) {
                        zombie.downMove();
                }
        }

        @Override
        public void keyReleased(KeyEvent e) {
                if(e.getKeyCode() == 39 || e.getKeyCode() == 37){
                        zombie.xyStop();
                }
                if(e.getKeyCode() == 38 || e.getKeyCode() == 40){
                        zombie.zStop();
                }
        }

        @Override
        public void run() {
                while(true){

                        //间隔发射豌豆
                        if(count % 60 == 1) {
                                for (int i = 0; i < 5; i++) {
                                        nowBg.getPeaList().add(new Pea(310, 92 + i * 100, nowBg));
                                }
                        }
                        zombie.isPea(nowBg);
                        count ++;
                        repaint();
                        try {
                                Thread.sleep(50);
                                if(zombie.isFlag()){
                                        JOptionPane.showMessageDialog(this,
                                                "恭喜您，成功通关!");
                                        System.exit(0);
                                }
                                if(zombie.isDeath()){
                                        JOptionPane.showMessageDialog(this,
                                                "僵尸已死亡，游戏失败!");
                                        System.exit(0);
                                }

                        } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                        }
                }
        }

}
