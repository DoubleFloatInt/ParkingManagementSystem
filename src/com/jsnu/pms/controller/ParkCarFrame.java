package com.jsnu.pms.controller;

import com.jsnu.pms.service.ICarService;

import javax.swing.*;
import java.awt.*;

/**
 * 停车界面
 * @author 李广帅
 * @Date 2020/4/3 7:04 下午
 */
public class ParkCarFrame extends JFrame {
    private Boolean hasCarport;
    private ICarService carService = null;

    public ParkCarFrame() throws HeadlessException {
        if (carService.getCarportNum() == 0) {
            this.hasCarport = false;
        } else {
            this.hasCarport = true;
        }
    }


    /**
     * 界面初始化函数
     */
    public void init() {

    }
}
