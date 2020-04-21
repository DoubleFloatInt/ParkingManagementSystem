package com.jsnu.pms.dao.impl;

import com.jsnu.pms.dao.ICarDao;
import com.jsnu.pms.data.CarNode;
import com.jsnu.pms.entity.Car;
import com.jsnu.pms.utils.CarType;
import com.jsnu.pms.utils.PSMUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author 李广帅
 * @Date 2020/4/4 6:32 下午
 */
public class CarDaoImpl implements ICarDao {
    private final CarNode carHead = new CarNode();
    private final CarNode appointmentHead = new CarNode();
    private final CarNode historyHead = new CarNode();
    private final Integer totalCarport = 100;
    private Integer[] typeACarNum = new Integer[20];
    private Integer[] typeBCarNum = new Integer[40];
    private Integer[] typeCCarNum = new Integer[40];


    public CarDaoImpl() {
        Arrays.fill(typeACarNum, 0);
        Arrays.fill(typeBCarNum, 0);
        Arrays.fill(typeCCarNum, 0);
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
            if (car != null) {
                cars.add(car);
            }
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
            node = node.getNext();
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
        if (car.getCarType() == CarType.BIG) {
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
                int index = PSMUtils.getIndexByParkPlace(car.getParkPlace());
                if (car.getCarType() == CarType.BIG) {
                    typeACarNum[index] = 0;
                } else if (car.getCarType() == CarType.MIDDLE) {
                    typeBCarNum[index] = 0;
                } else {
                    typeCCarNum[index] = 0;
                }
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
    public void updateCarStatus(String licensePlateNumber, Boolean status) {
        CarNode node = this.carHead.getNext();
        while(node != null) {
            Car car = node.getData();
            if (car.getLicensePlateNumber().equals(licensePlateNumber)) {
                car.setStatus(status);
                break;
            }
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

    @Override
    public String getPlaceID(CarType carType) {
        String parkPlaceId = null;
        if (carType == CarType.BIG) {
            for (int i = 0; i < typeACarNum.length; i++) {
                if (typeACarNum[i] == 0) {
                    parkPlaceId = String.format("A%d", i);
                    typeACarNum[i] = 1;
                    break;
                }
            }
        } else if (carType == CarType.MIDDLE) {
            for (int i = 0; i < typeBCarNum.length; i++) {
                if (typeBCarNum[i] == 0) {
                    parkPlaceId = String.format("B%d", i);
                    typeBCarNum[i] = 1;
                    break;
                }
            }
        } else {
            for (int i = 0; i < typeCCarNum.length; i++) {
                if (typeCCarNum[i] == 0) {
                    parkPlaceId = String.format("C%d", i);
                    typeCCarNum[i] = 1;
                    break;
                }
            }
        }
        return parkPlaceId;
    }

}
