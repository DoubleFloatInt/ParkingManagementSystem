package com.jsnu.pms.controller;

import com.jsnu.pms.entity.Member;
import com.jsnu.pms.service.IMemberService;
import com.jsnu.pms.service.impl.MemberServiceImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import static com.jsnu.pms.utils.FrameStyle.InitGlobalFont;

/**
 * @Author 周星晨
 * @Date 2020/4/3 19:01
 */
public class WorkbenchFrame extends JFrame implements MouseListener {
    private JButton appointmentBtn = new JButton("查看预约信息");
    private JButton carportInfoBtn = new JButton("查询车位信息");
    private JButton historyBtn = new JButton("查看停泊记录");
    private JButton MemberyBtn = new JButton("查看会员记录");
    private JButton exitBtn = new JButton("退出");

    //设置窗口的位置、大小
    public WorkbenchFrame() {
        //设置窗口的位置、大小
        this.setBounds(500, 200, 300, 300);

        //清空布局管理器，使组件位置相对于窗口位置
        setLayout(null);
        this.appointmentBtn.setBounds(50, 50, 200, 25);
        this.carportInfoBtn.setBounds(50, 90, 200, 25);
        this.historyBtn.setBounds(50, 130, 200, 25);
        this.MemberyBtn.setBounds(50, 170, 200, 25);
        this.exitBtn.setBounds(50, 210, 200, 25);

        appointmentBtn.setBorderPainted(false);
        appointmentBtn.setBorder(BorderFactory.createRaisedBevelBorder());
        carportInfoBtn.setBorderPainted(false);
        carportInfoBtn.setBorder(BorderFactory.createRaisedBevelBorder());
        historyBtn.setBorderPainted(false);
        historyBtn.setBorder(BorderFactory.createRaisedBevelBorder());
        exitBtn.setBorderPainted(false);
        exitBtn.setBorder(BorderFactory.createRaisedBevelBorder());


        this.appointmentBtn.addMouseListener(this);
        this.carportInfoBtn.addMouseListener(this);
        this.historyBtn.addMouseListener(this);
        this.MemberyBtn.addMouseListener(this);
        this.exitBtn.addMouseListener(this);

        this.add(appointmentBtn);
        this.add(carportInfoBtn);
        this.add(historyBtn);
        this.add(MemberyBtn);
        this.add(exitBtn);

        this.setVisible(true);
        this.getContentPane().setBackground(new java.awt.Color(188,237,230));
    }

    public static void main(String[] args) {
        InitGlobalFont(new Font("黑体", Font.PLAIN, 13));  //统一设置字体
        WorkbenchFrame workbenchFrame = new WorkbenchFrame();
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getSource() == this.appointmentBtn) {
            new AppointmentManageFrame();
        } else if (e.getSource() == this.carportInfoBtn) {
            new ParkInfoFrame();
        } else if (e.getSource() == this.historyBtn) {
            new HistroyFrame();
        } else if(e.getSource() == this.MemberyBtn){
            new MemberFrame();
        }else {
            this.dispose();
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
