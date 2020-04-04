package com.jsnu.pms.service.impl;

import com.jsnu.pms.dao.ICarDao;
import com.jsnu.pms.entity.Car;
import com.jsnu.pms.service.ICarService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author 李广帅
 * @Date 2020/4/4 4:54 下午
 */
public class CarServiceImpl implements ICarService {
    private ICarDao carDao = null;
    @Override
    public void parkCar(String licensePlateNumber) {
        Car car = new Car();
        car.setId(new Date().toString());
        car.setLicensePlateNumber(licensePlateNumber);
        car.setEntryTime(new Date());
        carDao.addCar(car);
    }

    @Override
    public void pickCar(String licensePlateNumber) {

    }

    @Override
    public void appointment(String licensePlateNumber) {

    }

    @Override
    public Integer getEmptyCarport() {
        return 0;
    }

    @Override
    public Integer getTotalCarport() {
        return 100;
    }

    @Override
    public Integer getCarNum() {
        return null;
    }

    @Override
    public List<Car> getAllCars() {
        List<Car> cars = new ArrayList<Car>();
        for (int i = 0; i < 30; i++) {
            Car car = new Car();
            car.setId(String.valueOf(i + 1));
            car.setLicensePlateNumber("苏C12345");
            car.setEntryTime(new Date());
            cars.add(car);
        }
        return cars;
    }
}
