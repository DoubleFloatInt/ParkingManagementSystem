package com.jsnu.pms.controller;

import com.jsnu.pms.service.ICarService;
import com.jsnu.pms.service.impl.CarServiceImpl;
import com.jsnu.pms.utils.PSMUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * 预约界面
 *
 * @author 李广帅
 * @Date 2020/4/3 7:05 下午
 */
public class AppointmentFrame extends JFrame implements MouseListener {
    private JLabel licensePlateNumberLabel = null;
    private JTextField licensePlateNumberText = null;
    private JButton appointmentBtn = null;

    private ICarService carService = null;

    public AppointmentFrame() throws HeadlessException {
        init();
    }

    public void init() {
        carService = new CarServiceImpl();


        this.licensePlateNumberLabel = new JLabel("请输入车牌号:");


        this.setSize(330, 200);
        this.setLocationRelativeTo(null);
        this.setTitle("预约");
        this.setLayout(null);
        this.setResizable(false);

        this.licensePlateNumberLabel = new JLabel("请输入车牌号:");
        this.licensePlateNumberLabel.setBounds(30, 30, 100, 30);

        this.licensePlateNumberText = new JTextField();
        this.licensePlateNumberText.setBounds(140, 30, 100, 30);


        this.appointmentBtn = new JButton("预约");
        this.appointmentBtn.setBounds(80, 100, 80, 50);
        this.appointmentBtn.addMouseListener(this);

        this.add(licensePlateNumberLabel);
        this.add(licensePlateNumberText);
        this.add(appointmentBtn);

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
                carService.addAppointment(licensePlateNumber);
                JOptionPane.showMessageDialog(this, "车牌号:" + licensePlateNumber + ",预约成功!");
                this.dispose();
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
