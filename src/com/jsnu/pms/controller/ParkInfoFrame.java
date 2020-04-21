package com.jsnu.pms.controller;

import com.jsnu.pms.entity.Car;
import com.jsnu.pms.service.ICarService;
import com.jsnu.pms.service.impl.CarServiceImpl;
import com.jsnu.pms.utils.CarType;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
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
    private HashMap<String, Car> carsA;
    private HashMap<String, Car> carsB;
    private HashMap<String, Car> carsC;

    public void test() {
        carService.parkCar("苏C12345", CarType.SMALL);
        carService.parkCar("苏C22345", CarType.SMALL);
        carService.parkCar("苏C32345", CarType.SMALL);
        carService.parkCar("苏C42345", CarType.SMALL);
        carService.parkCar("苏C52345", CarType.SMALL);

        carService.pickCar("苏C22345");

        carService.parkCar("苏C62345", CarType.SMALL);
        carService.parkCar("苏C72345", CarType.SMALL);
        carService.parkCar("苏C82345", CarType.SMALL);

        carService.pickCar("苏C72345");

        carService.parkCar("苏C92345", CarType.SMALL);
        carService.parkCar("苏C12341", CarType.SMALL);
        carService.parkCar("苏C12342", CarType.SMALL);
        carService.pickCar("苏C12345");
        carService.addAppointment("苏C12345", CarType.SMALL);
    }

    public ParkInfoFrame() {
        this.carService = new CarServiceImpl();
//        test();
        this.cars = carService.getAllCars();
        this.totalCarport = carService.getTotalCarport();
        this.carNum = carService.getCarNum();
        this.remainCarport = this.totalCarport - this.carNum;
        this.carsA = new HashMap<String, Car>();
        this.carsB = new HashMap<String, Car>();
        this.carsC = new HashMap<String, Car>();

        for (int i = 0; i < cars.size(); i++) {
            Car car = cars.get(i);
            if (car.getCarType() == CarType.BIG) {
                this.carsA.put(car.getParkPlace(), car);
            } else if (car.getCarType() == CarType.MIDDLE) {
                this.carsB.put(car.getParkPlace(), car);
            } else {
                this.carsC.put(car.getParkPlace(), car);
            }
        }
        init();
    }

    /**
     * 初始化函数
     */
    public void init() {


        this.setSize(1270, 945);
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


        for (int j = 0; j < 4; j++) {
            for (int i = 0; i < 10; i++) {
                Integer index = j * 10 + i;
                JButton btn = new JButton();
                btn.setBounds(i * 120 + 30, j * 80 + 90, 120, 80);
                Car car = carsC.get(String.format("C%d", index));
                if (car != null) {
                    if (car.getStatus()) {
                        btn.setBackground(Color.RED);
                        btn.setOpaque(true);
                        btn.setText("<html>" + String.format("车位:C%d", index) + "<br>" + car.getLicensePlateNumber() + "</html>");
                    } else {
                        btn.setText("<html>" + String.format("车位:C%d", index) + "<br>已被预约</html>");
                        btn.setBackground(Color.RED);
                        btn.setOpaque(true);
                    }
                } else {
                    btn.setText("<html>" + String.format("车位:C%d", index) + "<br>闲置</html>");
                    btn.setBackground(Color.GREEN);
                    btn.setOpaque(true);
                }
                this.carBtnList.add(btn);
                this.add(btn);
            }
        }
        for (int j = 0; j < 4; j++) {
            for (int i = 0; i < 10; i++) {
                Integer index = j * 10 + i;
                JButton btn = new JButton();
                btn.setBounds(i * 120 + 30, j * 80 + 410, 120, 80);
                Car car = carsB.get(String.format("B%d", index));
                if (car != null) {
                    if (car.getStatus()) {
                        btn.setBackground(Color.RED);
                        btn.setOpaque(true);
                        btn.setText("<html>" + String.format("车位:B%d", index) + "<br>" + car.getLicensePlateNumber() + "</html>");
                    } else {
                        btn.setText("<html>" + String.format("车位:B%d", index) + "<br>已被预约</html>");
                        btn.setBackground(Color.RED);
                        btn.setOpaque(true);
                    }
                } else {
                    btn.setText("<html>" + String.format("车位:B%d", index) + "<br>闲置</html>");
                    btn.setBackground(Color.GREEN);
                    btn.setOpaque(true);
                }
                this.carBtnList.add(btn);
                this.add(btn);
            }
        }
        for (int j = 0; j < 2; j++) {
            for (int i = 0; i < 10; i++) {
                Integer index = j * 10 + i;
                JButton btn = new JButton();
                btn.setBounds(i * 120 + 30, j * 80 + 730, 120, 80);
                Car car = carsA.get(String.format("A%d", index));
                if (car != null) {
                    if (car.getStatus()) {
                        btn.setBackground(Color.RED);
                        btn.setOpaque(true);
                        btn.setText("<html>" + String.format("车位:A%d", index) + "<br>" + car.getLicensePlateNumber() + "</html>");
                    } else {
                        btn.setText("<html>" + String.format("车位:A%d", index) + "<br>已被预约</html>");
                        btn.setBackground(Color.RED);
                        btn.setOpaque(true);
                    }
                } else {
                    btn.setText("<html>" + String.format("车位:A%d", index) + "<br>闲置</html>");
                    btn.setBackground(Color.GREEN);
                    btn.setOpaque(true);
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
