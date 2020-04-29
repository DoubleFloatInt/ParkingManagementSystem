package com.jsnu.pms.controller;

import com.jsnu.pms.entity.Member;

import javax.swing.*;
import java.awt.*;

import static com.jsnu.pms.utils.FrameStyle.InitGlobalFont;

/**
 * @Author 周星晨
 * @Date 2020/4/24 19:52
 *
 * 会员注册
 */
public class MemberPersonalFrame extends JFrame{
    private JLabel idLabel = null;
    private JTextField idText = null;
    private JLabel phoneLabel = null;
    private JTextField phoneText = null;
    private JLabel nameLable = null;
    private JTextField nameText = null;
    private JLabel memberLevelLabel = null;
    private JTextField memberLevelText = null;
    private JLabel memberMoneyLabel = null;
    private JTextField memberMoneyText = null;
    private JButton exitBtn = null;


    public MemberPersonalFrame(Member member){
        init(member);
    }

    public void init(Member member){
        // 初始化代码
        this.setTitle("会员个人中心");
        this.setSize(400, 440);
        this.setLocationRelativeTo(null);
        this.setLayout(null);

        this.idLabel = new JLabel("卡号:");
        this.idLabel.setBounds(70, 50, 100, 30);
        this.idText = new JTextField(10);
        this.idText.setBounds(170,50,150,30);
        this.idText.setText(member.getId());
        this.idText.setEditable(false);

        this.nameLable = new JLabel("用户名:");
        this.nameLable.setBounds(70, 90, 100, 30);
        this.nameText = new JTextField(10);
        this.nameText.setBounds(170,90,150,30);
        this.nameText.setText(member.getMemberName());
        this.nameText.setEditable(false);



        this.phoneLabel = new JLabel("绑定手机号：");
        this.phoneLabel.setBounds(70, 140, 100, 30);
        this.phoneText = new JTextField(10);
        this.phoneText.setBounds(170,130,150,30);
        this.phoneText.setText(member.getMembePhone());
        this.phoneText.setEditable(false);

        this.memberLevelLabel = new JLabel("会员等级：");
        this.memberLevelLabel.setBounds(70,180,100,30);
        this.memberLevelText = new JTextField(10);
        this.memberLevelText.setBounds(170,170,150,30);
        this.memberLevelText.setText(member.getMemberLevel());
        this.memberLevelText.setEditable(false);

        this.memberMoneyLabel = new JLabel("卡内余额：");
        this.memberMoneyLabel.setBounds(70,180,100,30);
        this.memberMoneyText = new JTextField(10);
        this.memberMoneyText.setBounds(170,250,150,30);
        this.memberMoneyText.setText(member.getMemberLevel());

        this.exitBtn = new JButton("退出");
        this.exitBtn.setBounds(150,280,70,30);


        this.add(idLabel);
        this.add(idText);
        this.add(phoneLabel);
        this.add(phoneText);
        this.add(nameLable);
        this.add(nameText);
        this.add(memberLevelLabel);
        this.add(memberLevelText);
        this.add(memberMoneyLabel);
        this.add(memberMoneyText);
        this.add(exitBtn);


        this.getContentPane().setBackground(new Color(188,237,230));
        this.setVisible(true);
    }

    public static void main(String[] args) {
        InitGlobalFont(new Font("黑体", Font.PLAIN, 15));  //统一设置字体
        new MemberPersonalFrame(new Member());
    }



}
