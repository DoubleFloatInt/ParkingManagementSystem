package com.jsnu.pms.controller;

import com.jsnu.pms.entity.Car;
import com.jsnu.pms.service.ICarService;
import com.jsnu.pms.service.impl.CarServiceImpl;
import com.jsnu.pms.utils.CarType;
import com.jsnu.pms.utils.FrameStyle;
import com.jsnu.pms.utils.JTextFieldHintListener;
import com.jsnu.pms.utils.PSMUtils;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.Enumeration;

import static com.jsnu.pms.utils.FrameStyle.InitGlobalFont;

/**
 * 预约界面
 *
 * @author 李广帅
 * @Date 2020/4/3 7:05 下午
 */
public class AppointmentFrame extends JFrame implements MouseListener {
    private JLabel licensePlateNumberLabel = null;
    private JTextField licensePlateNumberText = null;
    private JLabel carTypeLabel = null;
    private JComboBox<String> carTypeSelect = null;
    private JButton appointmentBtn = null;

    private ICarService carService = null;

    public AppointmentFrame() {
        init();
    }

    public void init() {
        carService = new CarServiceImpl();

        this.setSize(350, 220);
        this.setLocationRelativeTo(null);
        this.setTitle("预约");
        this.setLayout(null);
        this.setResizable(false);

        this.licensePlateNumberLabel = new JLabel("车牌号:");
        this.licensePlateNumberLabel.setBounds(30, 30, 100, 30);

        this.licensePlateNumberText = new JTextField();
        this.licensePlateNumberText.setBounds(140, 30, 100, 30);

        this.carTypeLabel = new JLabel("请选择车型:");
        this.carTypeLabel.setBounds(30, 80, 100, 30);

        this.carTypeSelect = new JComboBox<>();
        this.carTypeSelect.addItem("大型车");
        this.carTypeSelect.addItem("中型车");
        this.carTypeSelect.addItem("小型车");
        this.carTypeSelect.setBounds(140, 80, 100, 30);


        this.appointmentBtn = new JButton("预约");
        this.appointmentBtn.setBounds(110, 130, 100, 30);
        this.appointmentBtn.addMouseListener(this);
        //按钮样式：无边框，凸起
        appointmentBtn.setBorderPainted(false);
        appointmentBtn.setBorder(BorderFactory.createRaisedBevelBorder());

        this.add(licensePlateNumberLabel);
        this.add(licensePlateNumberText);
        this.add(carTypeLabel);
        this.add(carTypeSelect);
        this.add(appointmentBtn);
        licensePlateNumberText.addFocusListener(new JTextFieldHintListener(licensePlateNumberText, "请输入车牌号"));

        this.getContentPane().setBackground(new java.awt.Color(188,237,230));
        this.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getSource() == this.appointmentBtn) {
            String licensePlateNumber = this.licensePlateNumberText.getText();
            if (licensePlateNumber.equals("")) {
                JOptionPane.showMessageDialog(this, "请输入车牌号!");
            } else if (!PSMUtils.checkLicensePlateNumber(licensePlateNumber)) {
                JOptionPane.showMessageDialog(this, "您输入的车牌号格式有误!");
            } else {
                if (carService.getAppointment(licensePlateNumber) == null && carService.getCarBylicensePlateNumber(licensePlateNumber) == null) {
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
                    Car car = carService.addAppointment(licensePlateNumber, carType);
                    JOptionPane.showMessageDialog(this, "车牌号:" + car.getLicensePlateNumber() + ",预约成功!预约车位为:" + car.getParkPlace());
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "预约失败!");
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

    public static void main(String[] args) throws IOException {
        InitGlobalFont(new Font("宋体", Font.PLAIN, 13));  //统一设置字体
        new AppointmentFrame();

    }
}
