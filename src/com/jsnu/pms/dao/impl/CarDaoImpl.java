package com.jsnu.pms.dao.impl;

import com.jsnu.pms.dao.ICarDao;
import com.jsnu.pms.data.CarNode;
import com.jsnu.pms.entity.Car;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author 李广帅
 * @Date 2020/4/4 6:32 下午
 */
public class CarDaoImpl implements ICarDao {
    private CarNode carHead = new CarNode();
    private CarNode appointmentHead = new CarNode();
    private CarNode historyHead = new CarNode();
    private final Integer totalCarport = 100;


    public CarDaoImpl() {
        // 初始化链表
    }

    @Override
    public Integer getTotalCarport() {
        return totalCarport;
    }

    @Override
    public List<Car> getAllCars() {
        CarNode node = this.carHead.getNext();
        List<Car> cars = new ArrayList<Car>();
        if (node == null) {
            return null;
        }

        while (node != null) {
            Car car = node.getData();
            cars.add(car);
            node = node.getNext();
        }
        return cars;
    }

    @Override
    public Car getCarInfo(String licensePlateNumber) {
        CarNode node = this.carHead.getNext();
        while (node != null) {
            Car car = node.getData();
            if (car.getLicensePlateNumber().matches(licensePlateNumber)) {
                return car;
            }
        }
        return null;
    }

    @Override
    public Integer getCarsNum() {
        Integer count = 0;
        CarNode node = this.carHead.getNext();
        while (node != null) {
            count++;
            node = node.getNext();
        }
        return count;
    }

    @Override
    public Integer getEmptyCarportNum() {
        Integer emptyNum;
        emptyNum = this.totalCarport - this.getCarsNum();
        return emptyNum;
    }

    @Override
    public void addCar(Car car) {
        CarNode node = this.carHead;
        while (node.getNext() != null) {
            node = node.getNext();
        }
        CarNode newNode = new CarNode();
        newNode.setData(car);
        newNode.setPrev(node);
        newNode.setNext(null);
        node.setNext(newNode);
    }

    @Override
    public void deleteCar(String licensePlateNumber) {
        CarNode node = this.carHead.getNext();
        while (node != null) {
            Car car = node.getData();
            if (car.getLicensePlateNumber().matches(licensePlateNumber)) {
                if (node.getNext() == null) {
                    node.getPrev().setNext(null);
                } else {
                    node.getNext().setPrev(node.getPrev());
                    node.getPrev().setNext(node.getNext());
                }
                break;
            }
            node = node.getNext();
        }

    }

    @Override
    public void addAppointment(Car car) {
        CarNode node = this.appointmentHead;
        while (node.getNext() != null) {
            node = node.getNext();
        }
        CarNode newNode = new CarNode();
        newNode.setData(car);
        newNode.setPrev(node);
        newNode.setNext(null);
        node.setNext(newNode);
    }

    @Override
    public List<Car> getAllAppointment() {
        List<Car> appointment = new ArrayList<Car>();
        CarNode node = this.appointmentHead.getNext();
        while (node != null) {
            Car car = node.getData();
            appointment.add(car);
            node = node.getNext();
        }
        return appointment;
    }

    @Override
    public Car getAppointment(String licensePlateNumber) {
        CarNode node = this.appointmentHead.getNext();
        while (node != null) {
            Car car = node.getData();
            if (car.getLicensePlateNumber().matches(licensePlateNumber)) {
                return car;
            }
            node = node.getNext();
        }
        return null;
    }

    @Override
    public void deleteAppointment(String licensePlateNumber) {
        CarNode node = this.appointmentHead.getNext();
        while (node != null) {
            Car car = node.getData();
            if (car.getLicensePlateNumber().matches(licensePlateNumber)) {
                if (node.getNext() == null) {
                    node.getPrev().setNext(null);
                } else {
                    node.getNext().setPrev(node.getPrev());
                    node.getPrev().setNext(node.getNext());
                }
                break;
            }
            node = node.getNext();
        }
    }

    @Override
    public void addHistory(Car car) {
        CarNode node = this.historyHead;
        while (node.getNext() != null) {
            node = node.getNext();
        }
        CarNode newNode = new CarNode();
        newNode.setData(car);
        newNode.setPrev(node);
        newNode.setNext(null);
        node.setNext(newNode);
    }

    @Override
    public List<Car> getAllHistory() {
        List<Car> history = new ArrayList<Car>();
        CarNode node = this.historyHead.getNext();
        while (node != null) {
            history.add(node.getData());
            node = node.getNext();
        }
        return history;
    }

}
