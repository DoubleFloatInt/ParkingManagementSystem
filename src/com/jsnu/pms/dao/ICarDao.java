package com.jsnu.pms.dao;

import com.jsnu.pms.entity.Car;
import com.jsnu.pms.utils.CarType;

import java.util.List;

/**
 * @author 李广帅
 * @date 2020/4/4 6:15 下午
 */
public interface ICarDao {


    /**
     * 获取停车位数
     * @return
     */
    public Integer getTotalCarport();

    /**
     * 获取所有车辆信息
     * @return
     */
    public List<Car> getAllCars();


    /**
     * 根据车牌号获取车辆信息
     * @param licensePlateNumber
     * @return
     */
    public Car getCarInfo(String licensePlateNumber);


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
     * 更改汽车状态:预约、非预约
     * @param licensePlateNumber
     * @param status
     */
    public void updateCarStatus(String licensePlateNumber, Boolean status);


    /**
     * 添加预约
     * @param car
     */
    public void addAppointment(Car car);


    /**
     * 获取所有预约信息
     * @return
     */
    public List<Car> getAllAppointment();

    /**
     * 获取预约信息
     * @param licensePlateNumber
     * @return
     */
    public Car getAppointment(String licensePlateNumber);


    /**
     * 删除预约
     * @param licensePlateNumber
     */
    public void deleteAppointment(String licensePlateNumber);


    /**
     * 添加历史记录
     * @param car
     */
    public void addHistory(Car car);


    /**
     * 获取所有历史记录
     * @return
     */
    public List<Car> getAllHistory();


    /**
     * 获取停车位编号
     * @return
     */
    public String getPlaceID(CarType carType);

}
