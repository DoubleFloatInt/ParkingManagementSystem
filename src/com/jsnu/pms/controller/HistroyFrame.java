package com.jsnu.pms.controller;

import javax.swing.*;
import java.awt.*;
import java.util.Date;

/**
 * @Author 周星晨
 * @Date 2020/4/4 20:24
 */
public class HistroyFrame extends JFrame {

    private JTable table;

    public HistroyFrame(){

        String[] columnName = {"卡号","车牌号","开始时间","结束时间","总时","费用"};
        Object[][] rowData = new Object[6][6];


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

        HistroyFrame historyFrame = new HistroyFrame();
    }
}
