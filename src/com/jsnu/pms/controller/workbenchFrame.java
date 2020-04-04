package com.jsnu.pms.controller;

import javax.swing.*;
import java.awt.*;

/**
 * @Author 周星晨
 * @Date 2020/4/3 19:01
 */
public class workbenchFrame extends JFrame {
    JButton butnempty = new JButton("查询空车位");
    JButton butnusing = new JButton("查询当前停泊车辆");
    JButton butnlist = new JButton("查看停泊记录");
    private JButton butnexit = new JButton("退出");
    //设置窗口的位置、大小
    public workbenchFrame(){
        //设置窗口的位置、大小
        setBounds(500,200,300,300);
        setVisible(true);
        //清空布局管理器，使组件位置相对于窗口位置
        setLayout(null);
        butnempty.setBounds(50,50,200,25);
        butnusing.setBounds(50,90,200,25);
        butnlist.setBounds(50,130,200,25);
        butnexit.setBounds(50,170,200,25);
        butnempty.setBackground(Color.BLACK);
        butnempty.setForeground(Color.white);
        butnempty.setFocusPainted(false);
        butnusing.setBackground(Color.BLACK);
        butnusing.setForeground(Color.white);
        butnusing.setFocusPainted(false);
        butnlist.setBackground(Color.BLACK);
        butnlist.setForeground(Color.white);
        butnlist.setFocusPainted(false);
        butnexit.setBackground(Color.BLACK);
        butnexit.setForeground(Color.white);
        butnexit.setFocusPainted(false);
        this.add(butnempty);
        this.add(butnusing);
        this.add(butnlist);
        this.add(butnexit);

        //设置关闭
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        workbenchFrame workbenchFrame = new workbenchFrame();
    }
}
