package com.jsnu.pms.controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * 取车界面
 * @author 李广帅
 * @Date 2020/4/3 7:04 下午
 */
public class PickCarFrame extends JFrame {
    private JLabel licensePlateNumberLabel;
    private JTextField licensePlateNumberText;
    private JButton pickCarBtn;

    public PickCarFrame() throws HeadlessException {
        init();
    }

    /**
     * 界面初始化函数
     */
    public void init() {

        this.setTitle("取车界面");
        this.setSize(300, 200);
        this.setLocationRelativeTo(null);
        this.setLayout(null);


        this.licensePlateNumberLabel = new JLabel("请输入车牌号:");
        this.licensePlateNumberLabel.setBounds(30, 30, 100, 30);


        this.licensePlateNumberText = new JTextField();
        this.licensePlateNumberText.setBounds(150, 30, 100, 30);


        this.pickCarBtn = new JButton("取车");
        this.pickCarBtn.setBounds(100, 80, 80, 50);
        this.pickCarBtn.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("取车");
            }

            @Override
            public void mousePressed(MouseEvent e) {

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
        });

        this.add(licensePlateNumberLabel);
        this.add(licensePlateNumberText);
        this.add(pickCarBtn);

        this.setVisible(true);
    }

    public static void main(String[] args) {
        new PickCarFrame();
    }
}
