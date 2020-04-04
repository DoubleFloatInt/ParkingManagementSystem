package com.jsnu.pms.controller;

import com.jsnu.pms.service.ICarService;
import com.jsnu.pms.service.impl.CarServiceImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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
        this.setSize(500, 700);
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

        this.exitBtn = new JButton();
        this.exitBtn.setText("退出系统");
        this.exitBtn.setBounds(100, 500, 300, 100);


        // 给按钮添加监听
        this.parkCarBtn.addMouseListener(this);
        this.pickCarBtn.addMouseListener(this);
        this.appointmentBtn.addMouseListener(this);
        this.adminLoginBtn.addMouseListener(this);
        this.exitBtn.addMouseListener(this);

        // 将按钮添加至窗体
        this.add(this.parkCarBtn);
        this.add(this.pickCarBtn);
        this.add(this.appointmentBtn);
        this.add(this.adminLoginBtn);
        this.add(this.exitBtn);


        this.setVisible(true);

    }


    public static void main(String[] args) {
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
                System.out.println("无空位===");
                int option = JOptionPane.showConfirmDialog(this, "停车场暂无空位,您是否有提前预约?");
                if (JOptionPane.OK_OPTION == option) {
                    new ParkCarFrame();
//                    this.dispose();
                }
            } else {
                System.out.println("停车");
            }

        } else if (e.getSource() == (this.pickCarBtn)) {
            new PickCarFrame();
            System.out.println("取车");
        } else if (e.getSource() == (this.appointmentBtn)) {
            new AppointmentFrame();
            System.out.println("预约");
        } else if (e.getSource() == (this.adminLoginBtn)) {
            new LoginFrame();
            System.out.println("管理员登录");
        } else if (e.getSource() == (this.exitBtn)) {
            System.out.println("退出系统");
            int option = JOptionPane.showConfirmDialog(this, "是否退出系统?");
            if (JOptionPane.OK_OPTION == option) {
                ParkCarFrame parkCarFrame = new ParkCarFrame();
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