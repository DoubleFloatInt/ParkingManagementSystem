package com.jsnu.pms.controller;

import com.jsnu.pms.service.impl.MemberServiceImpl;
import com.jsnu.pms.utils.JTextFieldHintListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import static com.jsnu.pms.utils.FrameStyle.InitGlobalFont;

/**
 * @Author 周星晨
 * @Date 2020/4/24 19:50
 *
 * 会员登录
 */
public class MemberLoginFrame extends JFrame implements MouseListener {
    private JLabel phoneLabel = new JLabel("手机号:");
    private JLabel passwordLabel = new JLabel("密 码:");
    protected JTextField phoneText = new JTextField(10);
    private JTextField passwordText = new JTextField(10);
    private JButton loginBtn = new JButton("登录");
    private JButton cancelBtn = new JButton("取消");


    private MemberServiceImpl MemberService = null;

    public MemberLoginFrame(){
        init();
    }

    public void init() {
        MemberService = new MemberServiceImpl();

        //设置窗口的位置、大小
        this.setBounds(500, 200, 300, 300);
        //清空布局管理器，使组件位置相对于窗口位置
        this.setLayout(null);
        this.setTitle("会员登录");

        this.phoneLabel.setBounds(60, 50, 100, 25);
        this.phoneText.setBounds(110, 50, 110, 26);


        this.passwordLabel.setBounds(60, 80, 100, 25);
        this.passwordText.setBounds(110, 80, 110, 25);


        this.loginBtn.setBounds(60, 120, 60, 25);
        /*this.loginBtn.setBackground(Color.BLACK);
        this.loginBtn.setForeground(Color.white);*/
        this.loginBtn.setFocusPainted(false);


        this.cancelBtn.setBounds(165, 120, 60, 25);
        /*this.cancelBtn.setBackground(Color.BLACK);
        this.cancelBtn.setForeground(Color.white);*/
        this.cancelBtn.setFocusPainted(false);


        this.add(phoneLabel);
        this.add(phoneText);
        this.add(passwordLabel);
        this.add(passwordText);
        this.add(loginBtn);
        this.add(cancelBtn);
        phoneText.addFocusListener(new JTextFieldHintListener(phoneText, "请输入手机号"));
        passwordText.addFocusListener(new JTextFieldHintListener(passwordText, "请输入密码"));

        this.loginBtn.addMouseListener(this);
        this.cancelBtn.addMouseListener(this);
        loginBtn.setBorderPainted(false);
        cancelBtn.setBorder(BorderFactory.createRaisedBevelBorder());


        this.getContentPane().setBackground(new java.awt.Color(188,237,230));
        this.setVisible(true);
    }

    public static void main(String[] args) {
        InitGlobalFont(new Font("宋体", Font.PLAIN, 13));  //统一设置字体

        new MemberLoginFrame();

    }


    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getSource() == this.loginBtn) {
            String phone = this.phoneText.getText();
            String password = this.passwordText.getText();

            if (phone.matches("")) {
                JOptionPane.showMessageDialog(this, "请输入手机号!");
            } else if (password.matches("")) {
                JOptionPane.showMessageDialog(this, "请输入密码!");
            } else {
                if (MemberService.MemberLogin(phone,password)) {
                    System.out.println(MemberService.MemberLogin(phone,password));
                    JOptionPane.showMessageDialog(this, "登录成功!");
                    new MemberPersonalFrame(MemberService.findMember(phone,password));
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "用户名或密码输入错误!");
                    this.phoneText.setText("");
                    this.passwordText.setText("");
                }
            }

        } else if (e.getSource() == this.cancelBtn) {
            this.dispose();
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
