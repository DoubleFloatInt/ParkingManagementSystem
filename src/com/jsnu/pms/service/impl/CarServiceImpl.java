package com.jsnu.pms.service.impl;

import com.jsnu.pms.dao.ICarDao;
import com.jsnu.pms.entity.Car;
import com.jsnu.pms.service.ICarService;
import com.jsnu.pms.utils.CarType;
import com.jsnu.pms.utils.Factory;
import com.jsnu.pms.utils.PSMUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author 李广帅
 * @date 2020/4/4 4:54 下午
 */
public class CarServiceImpl implements ICarService {
    private ICarDao carDao = null;

    public CarServiceImpl() {
        carDao = Factory.getCarDao();
    }

    @Override
    public Boolean parkCar(String licensePlateNumber, CarType carType) {
        Car car = getAppointment(licensePlateNumber);
        if (car == null) {
            car = new Car();
            car.setId(PSMUtils.getId());
            car.setCarType(carType);
            car.setStatus(true);
            car.setParkPlace(carDao.getPlaceID(carType));
            car.setLicensePlateNumber(licensePlateNumber);
            car.setEntryTime(new Date());
            carDao.addCar(car);
        } else {
            carDao.updateCarStatus(licensePlateNumber, true);
            carDao.deleteAppointment(licensePlateNumber);
        }

        return true;
    }

    @Override
    public Car pickCar(String licensePlateNumber) {
        Car car = carDao.getCarInfo(licensePlateNumber);
        System.out.println(car);
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
        double hour = diff % nd / (double) nh;
        double money = 0;
        if (hour <= 0.5) {
            // 半小时内免费
            money = 0.0;
        } else if (hour > 0.5 && hour <= 2) {
            switch (car.getCarType()) {
                case BIG:
                    money = 10.0;
                    break;
                case MIDDLE:
                    money = 7.0;
                    break;
                case SMALL:
                    money = 5.0;
                    break;
                default:
                    money = 0;
            }
        } else {
            switch (car.getCarType()) {
                case BIG:
                    money += 10 + 3.0 * (hour - 2);
                    break;
                case MIDDLE:
                    money += 7 + 2.0 * (hour - 2);
                    break;
                case SMALL:
                    money += 5 + 1.0 * (hour - 2);
                    break;
                default:
                    money = 0;
            }
        }
        car.setMoney(money);
        addHistory(car);
        carDao.deleteCar(licensePlateNumber);
        return car;
    }

    @Override
    public Car addAppointment(String licensePlateNumber, CarType carType) {
        Car car = new Car();
        car.setId(PSMUtils.getId());
        car.setStatus(false);
        car.setParkPlace(carDao.getPlaceID(carType));
        car.setCarType(carType);
        car.setLicensePlateNumber(licensePlateNumber);
        car.setEntryTime(new Date());
        carDao.addAppointment(car);
        carDao.addCar(car);
        return car;
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
    public Car getCarBylicensePlateNumber(String licensePlateNumber) {
        return carDao.getCarInfo(licensePlateNumber);
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
