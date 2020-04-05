package com.jsnu.pms.controller;

import com.jsnu.pms.entity.Car;
import com.jsnu.pms.service.ICarService;
import com.jsnu.pms.service.impl.CarServiceImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * 取车界面
 * @author 李广帅
 * @Date 2020/4/3 7:04 下午
 */
public class PickCarFrame extends JFrame implements MouseListener {
    private JLabel licensePlateNumberLabel;
    private JTextField licensePlateNumberText;
    private JButton pickCarBtn;

    private ICarService carService = null;

    public PickCarFrame() throws HeadlessException {
        init();
    }

    /**
     * 界面初始化函数
     */
    public void init() {
        carService = new CarServiceImpl();
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
        this.pickCarBtn.addMouseListener(this);

        this.add(licensePlateNumberLabel);
        this.add(licensePlateNumberText);
        this.add(pickCarBtn);

        this.setVisible(true);
    }

    public static void main(String[] args) {
        new PickCarFrame();
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getSource().equals(this.pickCarBtn)) {
            if (this.licensePlateNumberText.getText().matches("")) {
                JOptionPane.showMessageDialog(this, "请输入车牌号!");
            } else {
                Car car = carService.pickCar(this.licensePlateNumberText.getText());
                if (car == null) {
                    JOptionPane.showMessageDialog(this, "取车失败,请确认车牌信息!");
                } else {
                    while (true) {
                        String s = JOptionPane.showInputDialog(this, "取车成功,停车费共计" + car.getMoney() + "元,请输入缴费金额");
                        if (s == null) {
                            s = "-1";
                        } else if (s.matches("")) {
                            s = "0";
                        }
                        if (Double.valueOf(s).doubleValue() == car.getMoney().doubleValue()) {
                            JOptionPane.showMessageDialog(this, "缴费成功!");
                            this.dispose();
                            break;
                        }
                    }
                }
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
