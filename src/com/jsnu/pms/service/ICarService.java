package com.jsnu.pms.service;

import com.jsnu.pms.entity.Car;

import java.util.List;

/**
 * @author 李广帅
 * @Date 2020/4/3 6:18 下午
 */
public interface ICarService {


    /**
     * 停车
     * @param licensePlateNumber 车牌号
     */
    public void parkCar(String licensePlateNumber);


    /**
     * 取车
     * @param licensePlateNumber
     */
    public void pickCar(String licensePlateNumber);


    /**
     * 预约
     * @param licensePlateNumber
     */
    public void appointment(String licensePlateNumber);


    /**
     * 获取停车场空位
     *
     * @return
     */
    public Integer getEmptyCarport();

    /**
     * 获取总车位数
     *
     * @return
     */
    public Integer getTotalCarport();


    /**
     * 获取停车场的汽车数
     *
     * @return
     */
    public Integer getCarNum();


    /**
     * 获取停车场内所有汽车信息
     * @return
     */
    public List<Car> getAllCars();


}
