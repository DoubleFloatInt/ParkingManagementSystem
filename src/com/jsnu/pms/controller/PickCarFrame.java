package com.jsnu.pms.controller;

import javax.swing.*;
import java.awt.*;

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


        this.licensePlateNumberLabel = new JLabel("请输入车牌号");
        this.licensePlateNumberLabel.setBounds(30, 100, 40, 20);


        this.licensePlateNumberText = new JTextField();


        this.pickCarBtn = new JButton();


        this.setVisible(true);
    }
}
