package com.jsnu.pms.service.impl;

import com.jsnu.pms.dao.ICarDao;
import com.jsnu.pms.entity.Car;
import com.jsnu.pms.service.ICarService;
import com.jsnu.pms.utils.Factory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author 李广帅
 * @Date 2020/4/4 4:54 下午
 */
public class CarServiceImpl implements ICarService {
    private ICarDao carDao = null;

    public CarServiceImpl() {
        carDao = Factory.getCarDao();
    }

    @Override
    public Boolean parkCar(String licensePlateNumber) {
        Car car = getAppointment(licensePlateNumber);
        if (car == null) {
            car = new Car();
            car.setId(String.valueOf(new Date().hashCode()));
            car.setLicensePlateNumber(licensePlateNumber);
            car.setEntryTime(new Date());
        }
        carDao.addCar(car);
        carDao.deleteAppointment(licensePlateNumber);
        return true;
    }

    @Override
    public Car pickCar(String licensePlateNumber) {
        Car car = carDao.getCarInfo(licensePlateNumber);

        if (car == null) {
            return null;
        }
        car.setLeaveTime(new Date());

        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long nd = 1000 * 24 * 60 * 60;
        long nh = 1000 * 60 * 60;
        long diff = 0;
        String entryTime = sd.format(car.getEntryTime());
        String leaveTime = sd.format(car.getLeaveTime());

        try {
            diff = sd.parse(leaveTime).getTime() - sd.parse(entryTime).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        // 获取时间间隔（小时）
        long hour = diff % nd / nh;
        Double money = hour * 5.5;
        car.setMoney(money);
        addHistory(car);
        carDao.deleteCar(licensePlateNumber);
        return car;
    }

    @Override
    public void addAppointment(String licensePlateNumber) {
        Car car = new Car();
        car.setId(String.valueOf(new Date().hashCode()));
        car.setLicensePlateNumber(licensePlateNumber);
        car.setEntryTime(new Date());
        carDao.addAppointment(car);
    }

    @Override
    public List<Car> getAllAppointment() {
        return carDao.getAllAppointment();
    }

    @Override
    public Car getAppointment(String licensePlateNumber) {
        return carDao.getAppointment(licensePlateNumber);
    }

    @Override
    public void deleteAppointment(String licensePlateNumber) {
        carDao.deleteAppointment(licensePlateNumber);
    }

    @Override
    public Integer getEmptyCarport() {
        return carDao.getEmptyCarportNum();
    }

    @Override
    public Integer getTotalCarport() {
        return carDao.getTotalCarport();
    }

    @Override
    public Integer getCarNum() {
        return carDao.getCarsNum();
    }

    @Override
    public List<Car> getAllCars() {
        List<Car> cars = carDao.getAllCars();
        if (cars == null) {
            cars = new ArrayList<>();
        }
        return cars;
    }

    @Override
    public List<Car> getAllHistory() {
        List<Car> history = carDao.getAllHistory();
        return history;
    }

    @Override
    public void addHistory(Car car) {
        carDao.addHistory(car);
    }
}
