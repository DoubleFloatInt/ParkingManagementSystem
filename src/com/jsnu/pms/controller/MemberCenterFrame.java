package com.jsnu.pms.controller;



import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import static com.jsnu.pms.utils.FrameStyle.InitGlobalFont;

/**
 * @Author 周星晨
 * @Date 2020/4/24 19:00
 *
 * 会员中心
 */
public class MemberCenterFrame extends JFrame implements MouseListener {

    private JButton memberLoginBtn;
    private JButton memberRegistrationBtn;
    private JButton exitBtn;

    public MemberCenterFrame(){
        init();
    }

    public void init(){
        // 初始化代码
        this.setTitle("会员中心");
        this.setSize(400, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(null);

        // 创建按钮
        this.memberLoginBtn = new JButton();
        this.memberLoginBtn.setText("会员登录");
        this.memberLoginBtn.setBounds(40, 100, 300, 100);

        this.memberRegistrationBtn = new JButton();
        this.memberRegistrationBtn.setText("会员注册");
        this.memberRegistrationBtn.setBounds(40, 200, 300, 100);

        this.exitBtn = new JButton();
        this.exitBtn.setText("退出");
        this.exitBtn.setBounds(40, 300, 300, 100);

        // 给按钮添加监听
        this.memberLoginBtn.addMouseListener(this);
        this.memberRegistrationBtn.addMouseListener(this);
        this.exitBtn.addMouseListener(this);

        // 将按钮添加至窗体
        this.add(this.memberLoginBtn);
        this.add(this.memberRegistrationBtn);
        this.add(this.exitBtn);

        memberLoginBtn.setBorderPainted(false);
        memberLoginBtn.setBorder(BorderFactory.createRaisedBevelBorder());
        memberRegistrationBtn.setBorderPainted(false);
        memberRegistrationBtn.setBorder(BorderFactory.createRaisedBevelBorder());
        exitBtn.setBorderPainted(false);
        exitBtn.setBorder(BorderFactory.createRaisedBevelBorder());

        this.getContentPane().setBackground(new java.awt.Color(188,237,230));
        this.setVisible(true);

    }

    public static void main(String[] args) {
        InitGlobalFont(new Font("黑体", Font.PLAIN, 13));  //统一设置字体
        MemberCenterFrame memberCenterFrame = new MemberCenterFrame();
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getSource() == this.memberLoginBtn){
            new MemberLoginFrame();
        }else if(e.getSource() == this.memberRegistrationBtn){
            new MemberRegistrationFrame();
        }else if(e.getSource() == this.exitBtn){
            int option = JOptionPane.showConfirmDialog(this,"是否退出会员中心");
            if(option == JOptionPane.OK_OPTION){
                dispose();
            }
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
