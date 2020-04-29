package com.jsnu.pms.controller;

import com.jsnu.pms.entity.Car;
import com.jsnu.pms.service.ICarService;
import com.jsnu.pms.service.impl.CarServiceImpl;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.List;

import static com.jsnu.pms.utils.FrameStyle.InitGlobalFont;

/**
 * @Author 周星晨
 * @Date 2020/4/4 20:24
 */
public class HistroyFrame extends JFrame {
    private ICarService carService = null;

    private List<Car> history = null;

    private JTable table;

    public HistroyFrame() {
        carService = new CarServiceImpl();
        history = carService.getAllHistory();
        String[] columnName = {"订单编号", "车牌号", "开始时间", "结束时间", "费用"};
        Object[][] rowData;
        if (history == null) {
            rowData = new Object[0][0];
        } else {
            rowData = new Object[history.size()][5];
        }
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        for (int i = 0; i < history.size(); i++) {
            rowData[i][0] = history.get(i).getId();
            rowData[i][1] = history.get(i).getLicensePlateNumber();
            rowData[i][2] = sd.format(history.get(i).getEntryTime());
            rowData[i][3] = sd.format(history.get(i).getLeaveTime());
            rowData[i][4] = history.get(i).getMoney();
        }


        //获取窗口容器
        Container container = getContentPane();
        //实列化表格
        table = new JTable(rowData, columnName);
        //增加组件
        container.add(new JScrollPane(table), BorderLayout.CENTER);


        setSize(800, 600);
        setVisible(true);
    }

    public static void main(String[] args) {
        InitGlobalFont(new Font("宋体", Font.PLAIN, 13));  //统一设置字体
        HistroyFrame historyFrame = new HistroyFrame();
    }
}
