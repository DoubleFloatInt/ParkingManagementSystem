package com.jsnu.pms.controller;

import com.jsnu.pms.entity.Car;
import com.jsnu.pms.service.ICarService;
import com.jsnu.pms.service.impl.CarServiceImpl;
import com.jsnu.pms.utils.CarType;
import com.jsnu.pms.utils.PSMUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * 停车界面
 *
 * @author 李广帅
 * @Date 2020/4/3 7:04 下午
 */
public class ParkCarFrame extends JFrame implements MouseListener {
    private Boolean hasCarport;
    private ICarService carService = null;


    private JLabel parkCarLabel;
    private JTextField parkCarText;
    private JLabel carTypeLabel;
    private JComboBox<String> carTypeSelect;
    private JButton parkCarBtn;

    public ParkCarFrame() throws HeadlessException {
        init();

        if (carService.getEmptyCarport() == 0) {
            this.hasCarport = false;
        } else {
            this.hasCarport = true;
        }
    }


    /**
     * 界面初始化函数
     */
    public void init() {
        carService = new CarServiceImpl();


        this.setSize(330, 200);
        this.setLocationRelativeTo(null);
        this.setTitle("停车");
        this.setLayout(null);
        this.setResizable(false);

        this.parkCarLabel = new JLabel("请输入车牌号:");
        this.parkCarLabel.setBounds(30, 30, 100, 30);

        this.parkCarText = new JTextField();
        this.parkCarText.setBounds(140, 30, 100, 30);

        this.carTypeLabel = new JLabel("请选择车型:");
        this.carTypeLabel.setBounds(30, 70, 100, 30);

        this.carTypeSelect = new JComboBox<>();
        this.carTypeSelect.addItem("大型车");
        this.carTypeSelect.addItem("中型车");
        this.carTypeSelect.addItem("小型车");
        this.carTypeSelect.setBounds(140, 70, 100, 30);

        this.parkCarBtn = new JButton("停车");
        this.parkCarBtn.setBounds(80, 100, 80, 50);
        this.parkCarBtn.addMouseListener(this);

        this.add(parkCarLabel);
        this.add(parkCarText);
        this.add(carTypeLabel);
        this.add(carTypeSelect);
        this.add(parkCarBtn);


        this.setVisible(true);
    }


    public static void main(String[] args) {
        ParkCarFrame parkCarFrame = new ParkCarFrame();
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getSource() == (this.parkCarBtn)) {
            String licensePlateNumber = this.parkCarText.getText();
            if (licensePlateNumber.equals("")) {
                JOptionPane.showMessageDialog(this, "请输入车牌号！！！");
            } else if (!PSMUtils.checkLicensePlateNumber(licensePlateNumber)) {
                JOptionPane.showMessageDialog(this, "您输入的车牌号格式有误!");
            } else {
                Car car = carService.getCarBylicensePlateNumber(licensePlateNumber);
                if (car == null) {
                    CarType carType;
                    switch (carTypeSelect.getSelectedItem().toString()) {
                        case "大型车":
                            carType = CarType.BIG;
                            break;
                        case "中型车":
                            carType = CarType.MIDDLE;
                            break;
                        case "小型车":
                            carType = CarType.SMALL;
                            break;
                        default:
                            carType = CarType.SMALL;
                    }
                    carService.parkCar(this.parkCarText.getText(), carType);
                    JOptionPane.showMessageDialog(this, this.parkCarText.getText() + "停车成功!");
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "请勿重复停车!");
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
