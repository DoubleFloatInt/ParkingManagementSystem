package com.jsnu.pms.controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 登录窗口
 *
 * @Author 周星晨
 * @Date 2020/4/3 17:21
 */
public class LoginFrame extends JFrame implements ActionListener {
    private JLabel usernameLabel = new JLabel("用户名:");
    private JLabel passwordLabel = new JLabel("密 码:");
    private JTextField usernameText = new JTextField(10);
    private JTextField passwordText = new JTextField(10);
    private JButton loginBtn = new JButton("登录");
    private JButton cancelBtn = new JButton("取消");

    public LoginFrame() {
        //设置窗口的位置、大小
        this.setBounds(500, 200, 300, 300);
        //设置关闭
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //清空布局管理器，使组件位置相对于窗口位置
        this.setLayout(null);

        this.usernameLabel.setBounds(60, 50, 100, 25);
        this.usernameText.setBounds(110, 50, 110, 26);


        this.passwordLabel.setBounds(60, 80, 100, 25);
        this.passwordText.setBounds(110, 80, 110, 25);


        this.loginBtn.setBounds(60, 120, 60, 25);
        this.loginBtn.setBackground(Color.BLACK);
        this.loginBtn.setForeground(Color.white);
        this.loginBtn.setFocusPainted(false);


        this.cancelBtn.setBounds(165, 120, 60, 25);
//        this.cancelBtn.setBackground(Color.BLACK);
//        this.cancelBtn.setForeground(Color.white);
        this.cancelBtn.setFocusPainted(false);


        this.add(usernameLabel);
        this.add(usernameText);
        this.add(passwordLabel);
        this.add(passwordText);
        this.add(loginBtn);
        this.add(cancelBtn);


        this.loginBtn.addActionListener(this);
        this.cancelBtn.addActionListener(this);

        this.setVisible(true);
    }

    public static void main(String[] args) {
        LoginFrame loginFrame = new LoginFrame();

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
