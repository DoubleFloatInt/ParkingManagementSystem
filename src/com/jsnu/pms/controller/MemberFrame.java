package com.jsnu.pms.controller;

import com.jsnu.pms.entity.Car;
import com.jsnu.pms.entity.Member;
import com.jsnu.pms.service.IMemberService;
import com.jsnu.pms.service.impl.CarServiceImpl;
import com.jsnu.pms.service.impl.MemberServiceImpl;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.List;

import static com.jsnu.pms.utils.FrameStyle.InitGlobalFont;

/**
 * @Author 周星晨
 * @Date 2020/4/4 20:24
 */
public class MemberFrame extends JFrame {
    private IMemberService memberService = null;

    private List<Member> members = null;

    private JTable table;

    public MemberFrame() {
        memberService = new MemberServiceImpl();
        members = memberService.getAllMember();
        String[] columnName = {"会员id", "电话号码", "姓名", "会员等级", "余额"};
        Object[][] rowData;
        if (members == null) {
            rowData = new Object[0][0];
        } else {
            rowData = new Object[members.size()][5];
        }


        for (int i = 0; i < members.size(); i++) {
            rowData[i][0] = members.get(i).getId();
            rowData[i][1] = members.get(i).getMembePhone();
            rowData[i][2] = members.get(i).getMemberName();
            rowData[i][3] = members.get(i).getMemberLevel();
            rowData[i][4] = members.get(i).getMoney();
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
        MemberFrame historyFrame = new MemberFrame();
    }
}
