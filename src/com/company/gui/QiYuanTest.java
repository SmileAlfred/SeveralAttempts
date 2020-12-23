package com.company.gui;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.applet.AudioClip;
import java.io.*;
import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.net.URI;
import java.net.URL;
public class QiYuanTest extends JFrame {
    public QiYuanTest() {
        super("————起源————"); //设置标题

        setSize(816, 624); //设置大小,

        setLocation(550, 200); //设置位置

        setResizable(false); //窗体大小固定
        String path = "C:/Users/我是刘优秀/Pictures/pingbao.jpg"; //背景图片的路径。（相对路径或者绝对路径。本例图片放于"java项目名"的文件下）

        ImageIcon background = new ImageIcon(path); // 背景图片

        JLabel label = new JLabel(background); // 把背景图片显示在一个标签里面

        label.setBounds(0, 0, this.getWidth(), this.getHeight()); // 把标签的大小位置设置为图片刚好填充整个面板

        JPanel imagePanel = (JPanel) this.getContentPane(); // 把内容窗格转化为JPanel，否则不能用方法setOpaque()来使内容窗格透明

        imagePanel.setOpaque(false);
        this.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE)); // 把背景图片添加到分层窗格的最底层作为背景

        File title_music;
        URI uri_t1;
        URL url_t1;
        try{
            title_music = new File("src/Title/title_music.wav"); //将背景音乐放入缓冲区
            uri_t1 = title_music.toURI();
            url_t1 = uri_t1.toURL(); //解析地址
            AudioClip aau;
            aau = Applet.newAudioClip(url_t1);
            aau.loop(); //循环播放
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        setLayout(null); //清空布局
        JButton b1=new JButton("-新游戏-"); //设置按钮名字
        b1.setFont(new Font("黑体", Font.PLAIN,25)); //设置按钮中的字体属性
        b1.setBounds(320,250,170,70); //设置按钮位置，及按钮大小
        b1.setContentAreaFilled(false); //设置按钮透明
        b1.setForeground(Color.WHITE); //设置前景色
        add(b1);

        JButton b2=new JButton("-设置-");
        b2.setFont(new Font("黑体", Font.PLAIN,25));
        b2.setBounds(320,320,170,70);
        b2.setContentAreaFilled(false);
        b2.setForeground(Color.WHITE);
        add(b2);

        JButton b3=new JButton("-结束-");
        b3.setFont(new Font("黑体", Font.PLAIN,25));
        b3.setBounds(320,390,170,70);
        b3.setContentAreaFilled(false);
        b3.setForeground(Color.WHITE);
        add(b3);

        setVisible(true); //刷新并设置可见
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //点关闭按钮时退出
    }
}
