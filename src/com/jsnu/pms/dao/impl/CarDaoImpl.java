package com.jsnu.pms.dao.impl;

import com.jsnu.pms.dao.ICarDao;
import com.jsnu.pms.entity.Car;

import java.util.List;

/**
 * @author 李广帅
 * @Date 2020/4/4 6:32 下午
 */
public class CarDaoImpl implements ICarDao {
    private Car head;

    public CarDaoImpl() {
        // 初始化链表
    }

    @Override
    public List<Car> getAllCars() {
        return null;
    }

    @Override
    public Integer getCarsNum() {
        return null;
    }

    @Override
    public Integer getEmptyCarportNum() {
        return null;
    }

    @Override
    public void addCar(Car car) {

    }

    @Override
    public void deleteCar(String licensePlateNumber) {

    }

    @Override
    public void addAppointment(Car car) {

    }

    @Override
    public void deleteAppointment(String licensePlateNumber) {

    }

}
