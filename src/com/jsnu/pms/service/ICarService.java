package com.jsnu.pms.service;

import com.jsnu.pms.entity.Car;
import com.jsnu.pms.utils.CarType;

import java.util.List;

/**
 * @author 李广帅
 * @Date 2020/4/3 6:18 下午
 */
public interface ICarService {


    /**
     * 停车
     *
     * @param licensePlateNumber 车牌号
     * @return
     */
    public Boolean parkCar(String licensePlateNumber, CarType carType);


    /**
     * 取车
     *
     * @param licensePlateNumber
     * @return
     */
    public Car pickCar(String licensePlateNumber);


    /**
     * 预约
     *
     * @param licensePlateNumber
     * @param carType
     * @return
     */
    public Car addAppointment(String licensePlateNumber, CarType carType);


    /**
     * 获取所有预约信息
     *
     * @return
     */
    public List<Car> getAllAppointment();

    /**
     * 获取预约信息
     *
     * @param licensePlateNumber
     * @return
     */
    public Car getAppointment(String licensePlateNumber);


    /**
     * 删除预约信息
     *
     * @param licensePlateNumber
     */
    public void deleteAppointment(String licensePlateNumber);


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
     *
     * @return
     */
    public List<Car> getAllCars();


    /**
     * 根据车牌号查询车辆信息
     * @param licensePlateNumber
     * @return
     */
    public Car getCarBylicensePlateNumber(String licensePlateNumber);


    /**
     * 获取所有历史记录
     *
     * @return
     */
    public List<Car> getAllHistory();


    /**
     * 添加历史记录
     *
     * @param car
     */
    public void addHistory(Car car);


}
