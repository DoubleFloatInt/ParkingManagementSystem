package com.jsnu.pms.controller;

import com.jsnu.pms.entity.Car;
import com.jsnu.pms.service.ICarService;
import com.jsnu.pms.service.impl.CarServiceImpl;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * @author 李广帅
 * @Date 2020/4/5 9:42 下午
 */
public class AppointmentManageFrame extends JFrame {
    private ICarService carService = null;

    private List<Car> appointment = null;

    private JTable table;

    public AppointmentManageFrame() {
        carService = new CarServiceImpl();
        appointment = carService.getAllAppointment();
        String[] columnName = {"订单编号", "车牌号", "车型", "停车位", "预约时间"};
        Object[][] rowData;
        if (appointment == null) {
            rowData = new Object[0][0];
        } else {
            rowData = new Object[appointment.size()][columnName.length];
        }
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        for (int i = 0; i < appointment.size(); i++) {
            rowData[i][0] = appointment.get(i).getId();
            rowData[i][1] = appointment.get(i).getLicensePlateNumber();
            rowData[i][2] = appointment.get(i).getCarType();
            rowData[i][3] = appointment.get(i).getParkPlace();
            rowData[i][4] = sd.format(appointment.get(i).getEntryTime());
        }


        //获取窗口容器
        Container container = getContentPane();
        //实列化表格
        table = new JTable(rowData, columnName);
        //增加组件
        container.add(new JScrollPane(table), BorderLayout.CENTER);


        setSize(500, 600);
        setVisible(true);
    }
}
