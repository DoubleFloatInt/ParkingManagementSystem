package com.jsnu.pms.dao;

import com.jsnu.pms.entity.Car;

import java.util.List;

/**
 * @author 李广帅
 * @Date 2020/4/4 6:15 下午
 */
public interface ICarDao {


    /**
     * 获取所有车辆信息
     * @return
     */
    public List<Car> getAllCars();


    /**
     * 获取停车数量
     * @return
     */
    public Integer getCarsNum();


    /**
     * 获取空位数量
     * @return
     */
    public Integer getEmptyCarportNum();



    /**
     * 添加停车信息
     * @param car
     */
    public void addCar(Car car);


    /**
     * 删除停车信息
     * @param licensePlateNumber
     */
    public void deleteCar(String licensePlateNumber);


    /**
     * 添加预约
     * @param car
     */
    public void addAppointment(Car car);


    /**
     * 删除预约
     * @param licensePlateNumber
     */
    public void deleteAppointment(String licensePlateNumber);




}
