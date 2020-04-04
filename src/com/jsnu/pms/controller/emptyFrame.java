package com.jsnu.pms.controller;

import javax.swing.*;
import java.awt.*;

/**
 * @Author 周星晨
 * @Date 2020/4/3 22:15
 */

public class emptyFrame extends JFrame {
    public emptyFrame(){
        //设置窗口的位置、大小
        setBounds(500,200,300,300);
        setVisible(true);
        //清空布局管理器，使组件位置相对于窗口位置
        setLayout(null);
        setTitle("空位查询");
        //
        JButton butnY = new JButton("");
        JButton butnN = new JButton("");
        butnY.setBackground(Color.green);
        butnN.setBackground(Color.red);
        butnY.setBounds(1,1,30,30);
        add(butnY);
        butnN.setBounds(25,1,35,35);
        add(butnN);
        int count=0;
        int Xnext=0;

        /*for(int i=0;i<100;i++) {
            count++;
            if(count%10==0) System.out.println('\n');
            if (i % 2 == 0){
                butnY.setBounds(1+Xnext,1,20,20);
                add(butnY);
                next+=4;
            }
            else
                add(butnN);

        }*/
    }

    public static void main(String[] args) {
        emptyFrame emptyFrame = new emptyFrame();

    }
}
