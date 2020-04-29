package com.jsnu.pms.controller;

import com.jsnu.pms.entity.Member;
import com.jsnu.pms.service.IMemberService;
import com.jsnu.pms.service.impl.MemberServiceImpl;
import com.jsnu.pms.utils.JTextFieldHintListener;
import com.jsnu.pms.utils.PSMUtils;


import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import static com.jsnu.pms.utils.FrameStyle.*;

/**
 * @Author 周星晨
 * @Date 2020/4/24 19:52
 *
 * 会员注册
 */
public class MemberRegistrationFrame extends JFrame implements MouseListener {
    private JLabel phoneLable = null;
    private JTextField phoneText = null;
    private JLabel nameLable = null;
    private JTextField nameText = null;
    private JLabel passwordLable = null;
    private JTextField passwordText = null;
    private JLabel confirmpswLable = null;
    private JTextField confirmpswText = null;
    private JLabel memberLevelLable = null;
    private JComboBox<String> memberLevelSelect = null;
    private JButton registratBtn = null;
    private JButton exitBtn = null;

    private JLabel nameRegularLable = null;
    private JLabel passwordRegularLable = null;
    private JLabel confirmRegularLable = null;
    private JLabel phoneRegularLable = null;

    IMemberService MemberService = null;
    private Member member;

    public MemberRegistrationFrame(){
        init();
    }

    public void init(){
        MemberService = new MemberServiceImpl();
        // 初始化代码
        this.setTitle("会员注册");
        this.setSize(600, 550);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(null);

        this.phoneLable = new JLabel("手机号：");
        this.phoneLable.setBounds(100, 50, 100, 30);
        phoneRegularLable = new JLabel("*手机号为11位数字");
        phoneRegularLable.setBounds(325,55,300,20);
        Regular(phoneRegularLable);

        this.phoneText = new JTextField(11);
        this.phoneText.setBounds(170,50,150,30);
        phoneText.addFocusListener(new JTextFieldHintListener(phoneText, "请输入手机号"));

        this.nameLable = new JLabel("用户名:");
        this.nameLable.setBounds(100, 90, 100, 30);

        this.nameText = new JTextField(10);
        this.nameText.setBounds(170,90,150,30);
        nameText.addFocusListener(new JTextFieldHintListener(nameText, "请输入用户名"));

        nameRegularLable = new JLabel("*6-10个数字/字母/下划线组成，不区分大小写");
        nameRegularLable.setBounds(325,95,300,20);
        Regular(nameRegularLable);

        this.passwordLable = new JLabel("密 码:");
        this.passwordLable.setBounds(100, 130, 100, 30);


        this.passwordText = new JTextField(10);
        this.passwordText.setBounds(170,130,150,30);
        passwordText.addFocusListener(new JTextFieldHintListener(passwordText, "请输入密码"));

        passwordRegularLable = new JLabel("*6-10个数字/字符/下划线组成，不区分大小写");
        passwordRegularLable.setBounds(325,135,300,20);
        Regular(passwordRegularLable);

        this.confirmpswLable = new JLabel("确认密码：");
        this.confirmpswLable.setBounds(100,170,150,30);

        this.confirmpswText = new JTextField(10);
        this.confirmpswText.setBounds(170,170,150,30);
        confirmpswText.addFocusListener(new JTextFieldHintListener(confirmpswText, "请确认密码"));



        this.memberLevelLable = new JLabel("会员等级：");
        this.memberLevelLable.setBounds(100,220,100,30);
        this.memberLevelSelect = new JComboBox<>();
        this.memberLevelSelect.addItem("钻石会员");
        this.memberLevelSelect.addItem("铂金会员");
        this.memberLevelSelect.addItem("黄金会员");
        this.memberLevelSelect.setBounds(170, 220, 100, 30);



        this.registratBtn = new JButton("注册");
        this.registratBtn.setBounds(140,290,70,30);
        this.exitBtn = new JButton("退出");
        this.exitBtn.setBounds(280,290,70,30);

        this.registratBtn.addMouseListener(this);
        this.exitBtn.addMouseListener(this);

        this.add(phoneLable);
        this.add(phoneText);
        this.add(nameLable);
        this.add(nameText);
        this.add(passwordLable);
        this.add(passwordText);
        this.add(confirmpswLable);
        this.add(confirmpswText);
        this.add(memberLevelLable);
        this.add(memberLevelSelect);
        this.add(nameRegularLable);
        this.add(passwordRegularLable);
        this.add(phoneRegularLable);


        this.add(registratBtn);
        this.add(exitBtn);


        this.getContentPane().setBackground(new java.awt.Color(188,237,230));
        this.setVisible(true);
    }

    public static void main(String[] args) {
        InitGlobalFont(new Font("黑体", Font.PLAIN, 15));  //统一设置字体
        new MemberRegistrationFrame();
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

        if (e.getSource() == this.registratBtn) {

            boolean flag = true;
            String memberphone = this.phoneText.getText();
            String membername = this.nameText.getText();
            String password = this.passwordText.getText();
            String confirmPsw = this.confirmpswText.getText();
            if (!PSMUtils.checkMemberPhone(memberphone)) {
                //JOptionPane.showMessageDialog(this, "请输入手机号!");
                ErrorRegular(phoneRegularLable);
                flag = false;
            }

            if (!PSMUtils.checkMemberPassword(membername)) {
                //JOptionPane.showMessageDialog(this, "请输入用户名!");
                ErrorRegular(nameRegularLable);
                flag = false;
            }
            if (!PSMUtils.checkMemberPassword(password)) {
                //JOptionPane.showMessageDialog(this, "请输入密码!");
                ErrorRegular(passwordRegularLable);
                flag = false;
            }
            if(!password.equals(confirmPsw)) {
                confirmRegularLable = new JLabel("*密码不一致：");
                confirmRegularLable.setBounds(325, 175, 300, 20);
                this.add(confirmRegularLable);
                ErrorRegular(confirmRegularLable);
                flag = false;
            }
            if(flag == true) {
                member = new Member();
                member.setMembePhone(this.phoneText.getText());
                member.setMemberName(this.nameText.getText());
                member.setMemberPassword(this.passwordText.getText());
                member.setMemberLevel(this.memberLevelSelect.getSelectedItem().toString());
                System.out.println(member.toString());
                MemberService.addMember(member);
                JOptionPane.showMessageDialog(this, "注册成功!");
                this.dispose();
            }else if(flag == false){
                JOptionPane.showMessageDialog(this, "请注意格式问题!");
                this.dispose();
                new MemberRegistrationFrame();
            }
        } else if (e.getSource() == this.exitBtn) {
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
