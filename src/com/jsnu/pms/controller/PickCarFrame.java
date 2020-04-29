package com.jsnu.pms.controller;

import com.jsnu.pms.entity.Car;
import com.jsnu.pms.service.ICarService;
import com.jsnu.pms.service.impl.CarServiceImpl;
import com.jsnu.pms.utils.JTextFieldHintListener;
import com.jsnu.pms.utils.PSMUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import static com.jsnu.pms.utils.FrameStyle.InitGlobalFont;

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
        licensePlateNumberText.addFocusListener(new JTextFieldHintListener(licensePlateNumberText, "请输入车牌号"));

        this.pickCarBtn = new JButton("取车");
        this.pickCarBtn.setBounds(95, 85, 90, 40);
        this.pickCarBtn.addMouseListener(this);
        pickCarBtn.setBorderPainted(false);
        pickCarBtn.setBorder(BorderFactory.createRaisedBevelBorder());

        this.add(licensePlateNumberLabel);
        this.add(licensePlateNumberText);
        this.add(pickCarBtn);


        this.getContentPane().setBackground(new java.awt.Color(188,237,230));
        this.setVisible(true);
    }

    public static void main(String[] args) {
        InitGlobalFont(new Font("宋体", Font.PLAIN, 13));  //统一设置字体
        new PickCarFrame();
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getSource().equals(this.pickCarBtn)) {
            String licensePlateNumber = this.licensePlateNumberText.getText();
            if (licensePlateNumber.matches("")) {
                JOptionPane.showMessageDialog(this, "请输入车牌号!");
            } else if(!PSMUtils.checkLicensePlateNumber(licensePlateNumber)) {
                JOptionPane.showMessageDialog(this, "车牌号格式错误!");
            } else {
                Car car = carService.getCarBylicensePlateNumber(licensePlateNumber);
                if (car == null) {
                    JOptionPane.showMessageDialog(this, "取车失败!");
                } else if (!car.getStatus()) {
                    int option = JOptionPane.showConfirmDialog(this, "该车辆是预约车,是否取车?");
                    if (JOptionPane.OK_OPTION == option) {
                        car = carService.pickCar(licensePlateNumber);
                        carService.deleteAppointment(licensePlateNumber);
                        getMoney(car);
                    }
                } else {
                    car = carService.pickCar(this.licensePlateNumberText.getText());
                    getMoney(car);
                }
            }

        }
    }

    private void getMoney(Car car) {
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
