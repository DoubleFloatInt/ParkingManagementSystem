package com.jsnu.pms.controller;

import com.jsnu.pms.entity.Admin;
import com.jsnu.pms.service.IAdminService;
import com.jsnu.pms.service.impl.AdminServiceImpl;
import com.jsnu.pms.utils.JTextFieldHintListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import static com.jsnu.pms.utils.FrameStyle.InitGlobalFont;

/**
 * 管理员登录窗口
 *
 * @Author 周星晨
 * @Date 2020/4/3 17:21
 */
public class LoginFrame extends JFrame implements MouseListener {
    private JLabel usernameLabel = new JLabel("用户名:");
    private JLabel passwordLabel = new JLabel("密 码:");
    protected JTextField usernameText = new JTextField(10);
    private JTextField passwordText = new JTextField(10);
    private JButton loginBtn = new JButton("登录");
    private JButton cancelBtn = new JButton("取消");



    private IAdminService adminService = null;

    public LoginFrame() {
        adminService = new AdminServiceImpl();

        //设置窗口的位置、大小
        this.setBounds(500, 200, 300, 300);
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
        this.cancelBtn.setBackground(Color.BLACK);
        this.cancelBtn.setForeground(Color.white);
        this.cancelBtn.setFocusPainted(false);


        this.add(usernameLabel);
        this.add(usernameText);
        this.add(passwordLabel);
        this.add(passwordText);
        this.add(loginBtn);
        this.add(cancelBtn);
        usernameText.addFocusListener(new JTextFieldHintListener(usernameText, "请输入用户名"));
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

        LoginFrame loginFrame = new LoginFrame();

    }


    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getSource() == this.loginBtn) {
            String username = this.usernameText.getText();
            String password = this.passwordText.getText();

            if (username.matches("")) {
                JOptionPane.showMessageDialog(this, "请输入用户名!");
            } else if (password.matches("")) {
                JOptionPane.showMessageDialog(this, "请输入密码!");
            } else {
                if (adminService.login(username, password)) {
                    JOptionPane.showMessageDialog(this, "登录成功!");
                    new WorkbenchFrame();
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "用户名或密码输入错误!");
                    this.usernameText.setText("");
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
