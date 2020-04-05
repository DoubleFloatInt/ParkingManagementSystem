package com.jsnu.pms.dao;

import com.jsnu.pms.dao.impl.CarDaoImpl;
import com.jsnu.pms.entity.Car;

import java.util.Date;
import java.util.List;

/**
 * @author 李广帅
 * @Date 2020/4/5 8:18 下午
 */
public class TestCarDao {


    public static void main(String[] args) {
        Car car = new Car("", "", new Date(), new Date(), 123.0);
        ICarDao carDao = new CarDaoImpl();
        Car car2 = new Car("", "123", new Date(), new Date(), 123.0);
        carDao.addHistory(car2);
        carDao.addHistory(car);
        carDao.addHistory(car);
        carDao.addHistory(car);
        carDao.addHistory(car);
        carDao.addHistory(car);
        carDao.addHistory(car);
        carDao.addHistory(car);
        carDao.addHistory(car);
        carDao.addHistory(car);
        carDao.addHistory(car);
        carDao.addHistory(car);
        Car car3 = new Car("", "234", new Date(), new Date(), 123.0);
        carDao.addHistory(car3);

        List<Car> cars = carDao.getAllHistory();
        for (Car car1 : cars) {
            System.out.println(car1);
        }


    }
}
