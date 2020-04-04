package com.jsnu.pms.controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @Author 周星晨
 * @Date 2020/4/3 17:21
 *
 */
public class LoginFrame extends JFrame implements ActionListener {
    JLabel nameLabel = new JLabel("用户名：");
    JLabel pwdLabel = new JLabel("密 码:");
    JTextField name = new JTextField(10);
    JTextField password = new JTextField(10);
    JButton butnSure = new JButton("确定");
    JButton butnCancel = new JButton("取消");
    public LoginFrame(){
        //设置窗口的位置、大小
        setBounds(500,200,300,300);
        setVisible(true);
        //清空布局管理器，使组件位置相对于窗口位置
        setLayout(null);
        nameLabel.setBounds(60,50,100,25);
        name.setBounds(110,50,110,26);
        this.add(nameLabel);
        this.add(name);
        pwdLabel.setBounds(60,80,100,25);
        password.setBounds(110,80,110,25);
        this.add(pwdLabel);
        this.add(password);
        butnSure.setBounds(60,120,60,25);
        butnCancel.setBounds(165,120,60,25);
        butnSure.setBackground(Color.BLACK);
        butnSure.setForeground(Color.white);
        butnSure.setFocusPainted(false);
        butnCancel.setBackground(Color.BLACK);
        butnCancel.setForeground(Color.white);
        butnCancel.setFocusPainted(false);
        this.add(butnSure);
        this.add(butnCancel);
        butnSure.addActionListener(this);
        butnCancel.addActionListener(this);
        //设置关闭
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        LoginFrame loginFrame = new LoginFrame();

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
