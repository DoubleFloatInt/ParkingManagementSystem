package com.jsnu.pms.controller;

import com.jsnu.pms.service.ICarService;
import com.jsnu.pms.service.impl.CarServiceImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import static com.jsnu.pms.utils.FrameStyle.InitGlobalFont;

/**
 * 主程序界面
 *
 * @author 李广帅
 * @Date 2020/4/3 4:43 下午
 */
public class MainFrame extends JFrame implements MouseListener {
    private JButton parkCarBtn;
    private JButton pickCarBtn;
    private JButton appointmentBtn;
    private JButton adminLoginBtn;
    private JButton memberCenterBtn;
    private JButton exitBtn;

    public MainFrame() throws HeadlessException {
        init();
    }

    /**
     * 界面初始化函数
     */
    public void init() {
        // 初始化代码
        this.setTitle("停车场管理系统");
        this.setSize(550, 800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(null);

        // 创建按钮
        this.parkCarBtn = new JButton();
        this.parkCarBtn.setText("停车");
        this.parkCarBtn.setBounds(100, 100, 300, 100);

        this.pickCarBtn = new JButton();
        this.pickCarBtn.setText("取车");
        this.pickCarBtn.setBounds(100, 200, 300, 100);

        this.appointmentBtn = new JButton();
        this.appointmentBtn.setText("预约");
        this.appointmentBtn.setBounds(100, 300, 300, 100);

        this.adminLoginBtn = new JButton();
        this.adminLoginBtn.setText("管理员登录");
        this.adminLoginBtn.setBounds(100, 400, 300, 100);

        this.memberCenterBtn = new JButton();
        this.memberCenterBtn.setText("会员中心");
        this.memberCenterBtn.setBounds(100, 500, 300, 100);

        this.exitBtn = new JButton();
        this.exitBtn.setText("退出系统");
        this.exitBtn.setBounds(100, 600, 300, 100);


        // 给按钮添加监听
        this.parkCarBtn.addMouseListener(this);
        this.pickCarBtn.addMouseListener(this);
        this.appointmentBtn.addMouseListener(this);
        this.adminLoginBtn.addMouseListener(this);
        this.memberCenterBtn.addMouseListener(this);
        this.exitBtn.addMouseListener(this);

        // 将按钮添加至窗体
        this.add(this.parkCarBtn);
        this.add(this.pickCarBtn);
        this.add(this.appointmentBtn);
        this.add(this.adminLoginBtn);
        this.add(this.memberCenterBtn);
        this.add(this.exitBtn);

        parkCarBtn.setBorderPainted(false);
        parkCarBtn.setBorder(BorderFactory.createRaisedBevelBorder());
        pickCarBtn.setBorderPainted(false);
        pickCarBtn.setBorder(BorderFactory.createRaisedBevelBorder());
        appointmentBtn.setBorderPainted(false);
        appointmentBtn.setBorder(BorderFactory.createRaisedBevelBorder());
        adminLoginBtn.setBorderPainted(false);
        adminLoginBtn.setBorder(BorderFactory.createRaisedBevelBorder());
        memberCenterBtn.setBorderPainted(false);
        memberCenterBtn.setBorder(BorderFactory.createRaisedBevelBorder());
        exitBtn.setBorderPainted(false);
        exitBtn.setBorder(BorderFactory.createRaisedBevelBorder());


        this.getContentPane().setBackground(new java.awt.Color(188,237,230));
        this.setVisible(true);

    }


    public static void main(String[] args) {
        InitGlobalFont(new Font("黑体", Font.PLAIN, 13));  //统一设置字体
        MainFrame mainFrame = new MainFrame();
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if ((e.getSource()) == (this.parkCarBtn)) {
            ICarService carService = new CarServiceImpl();
            if (carService.getEmptyCarport() == 0) {
                int option = JOptionPane.showConfirmDialog(this, "停车场暂无空位,您是否有提前预约?");
                if (JOptionPane.OK_OPTION == option) {
                    new ParkCarFrame();
                }
            } else {
                new ParkCarFrame();
            }

        } else if (e.getSource() == (this.pickCarBtn)) {
            new PickCarFrame();
        } else if (e.getSource() == (this.appointmentBtn)) {
            new AppointmentFrame();
        } else if (e.getSource() == (this.adminLoginBtn)) {
            new LoginFrame();
        } else if (e.getSource() == (this.memberCenterBtn)) {
            new MemberCenterFrame();
        }else if (e.getSource() == (this.exitBtn)) {
            int option = JOptionPane.showConfirmDialog(this, "是否退出系统?");
            if (JOptionPane.OK_OPTION == option) {
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
