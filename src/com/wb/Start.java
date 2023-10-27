package com.wb;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Start extends JFrame {
    Image offScreemImage = null;
    int width = 1000;
    int height = 600;
    public static boolean start = false;
    //窗口启动
    public void launch(){
        //基本设置
        setTitle("PVZ");
        setSize(width,height);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(3);
        setResizable(false);
        setVisible(true);
        //添加键盘监视器
        this.addKeyListener(new Start.KeyMoitor());
        //重绘
        while(true){
            repaint();
            try {
                Thread.sleep(25);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    //paint方法
    @Override
    public void paint(Graphics g){
        if(offScreemImage == null){
            offScreemImage = this.createImage(width,height);
        }
        Graphics gImage = offScreemImage.getGraphics();

        gImage.setColor(Color.gray);
        gImage.fillRect(0,0,width,height);
        gImage.setColor(Color.BLACK);
        if(start) {
            MyFrame myFrame = new MyFrame();
            this.setVisible(false);
        } else {
            gImage.setFont(new Font("宋体", Font.BOLD, 50));
            gImage.drawString("开始游戏", 400, 300);
            gImage.drawString("按”1“开始游戏", 300, 400);
        }

        g.drawImage(offScreemImage,0,0,null);
    }
    //键盘监视器
    class KeyMoitor extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e){
            if(e.getKeyCode() == KeyEvent.VK_1){
                start = true;
            }
        }
    }

    public static void main(String[] args) {
        Start start = new Start();
        start.launch();
    }

}
