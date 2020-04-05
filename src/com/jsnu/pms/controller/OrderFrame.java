package com.jsnu.pms.controller;

import javax.swing.*;
import java.awt.*;

/**
 * @Author 周星晨
 * @Date 2020/4/4 20:39
 */
public class OrderFrame extends JFrame {

    private JTable table;

    public OrderFrame(){
        String[] columnName = {"卡号","车牌号","开始时间","车位"};
        Object[][] rowData = new Object[10][4];

        //获取窗口容器
        Container container = getContentPane();
        //实列化表格
        table = new JTable(rowData,columnName);
        //增加组件
        container.add(new JScrollPane(table),BorderLayout.CENTER);
        
        
        setSize(600,600);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        OrderFrame orderFrame = new OrderFrame();
    }
}
