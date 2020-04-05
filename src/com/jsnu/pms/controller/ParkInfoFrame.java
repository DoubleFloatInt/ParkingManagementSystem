package com.jsnu.pms.controller;

import com.jsnu.pms.entity.Car;
import com.jsnu.pms.service.ICarService;
import com.jsnu.pms.service.impl.CarServiceImpl;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author 李广帅
 * @Date 2020/4/3 22:15
 */

public class ParkInfoFrame extends JFrame {
    private ICarService carService = null;
    private final int CARPORT_NUM = 100;
    private JLabel totalLabel;
    private JLabel emptyLabel;
    private JLabel remainLabel;
    private List<JButton> carBtnList;
    private Integer totalCarport;
    private Integer carNum;
    private Integer remainCarport;
    private List<Car> cars;

    public ParkInfoFrame() {
        init();
    }

    /**
     * 初始化函数
     */
    public void init() {
        this.carService = new CarServiceImpl();
        this.cars = carService.getAllCars();
        this.totalCarport = carService.getTotalCarport();
        this.carNum = carService.getCarNum();
        this.remainCarport = this.totalCarport - this.carNum;



        this.setSize(1200, 800);
        this.setLocationRelativeTo(null);
        this.setTitle("停车情况");
        this.setLayout(null);

        this.carBtnList = new ArrayList<JButton>();

        this.totalLabel = new JLabel("总车位数:" + String.valueOf(this.totalCarport));
        this.totalLabel.setBounds(250, 50, 150, 50);

        this.emptyLabel = new JLabel("空车位数:" + String.valueOf(this.carNum));
        this.emptyLabel.setBounds(450, 50, 150, 50);

        this.remainLabel = new JLabel("剩余车位数:" + String.valueOf(this.remainCarport));
        this.remainLabel.setBounds(650, 50, 150, 50);


        this.add(totalLabel);
        this.add(emptyLabel);
        this.add(remainLabel);



        for (int j = 0; j < 10; j++) {
            for (int i = 0; i < 10; i++) {
                JButton btn = new JButton();
                btn.setBounds(i * 115 + 30, j * 65 + 100, 100, 50);
                Integer index = j * 25 + i;
                if (this.cars.size() > index) {
                    btn.setBackground(Color.RED);
                    btn.setText(cars.get(index).getLicensePlateNumber());

                } else {
                    btn.setText("闲置");
                    btn.setBackground(Color.GREEN);
                }
                this.carBtnList.add(btn);
                this.add(btn);
            }
        }


        this.setVisible(true);
    }

    public static void main(String[] args) {
        ParkInfoFrame parkInfoFrame = new ParkInfoFrame();
    }
}
