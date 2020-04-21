package com.jsnu.pms.entity;

import com.jsnu.pms.utils.CarType;

import java.util.Date;

/**
 * 车，用户存储汽车的订单编号，车牌号，进入和离开时间及对其收费金额
 * @author 李广帅
 * @Date 2020/4/3 4:44 下午
 */
public class Car {

    /**
     * 订单编号
     */
    private String id;

    /**
     * 车牌号
     */
    private String licensePlateNumber;

    /**
     * 车型
     */
    private CarType carType;

    /**
     * 车位编号
     */
    private String parkPlace;

    /**
     * 汽车状态：true停车、false预约
     */
    private Boolean status;

    /**
     * 进入时间
     */
    private Date entryTime;

    /**
     * 离开时间
     */
    private Date leaveTime;

    /**
     * 收费金额
     */
    private Double money;

    public Car() {
    }

    public Car(String id, String licensePlateNumber, CarType carType, String parkPlace, Boolean status, Date entryTime, Date leaveTime, Double money) {
        this.id = id;
        this.licensePlateNumber = licensePlateNumber;
        this.carType = carType;
        this.parkPlace = parkPlace;
        this.status = status;
        this.entryTime = entryTime;
        this.leaveTime = leaveTime;
        this.money = money;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLicensePlateNumber() {
        return licensePlateNumber;
    }

    public void setLicensePlateNumber(String licensePlateNumber) {
        this.licensePlateNumber = licensePlateNumber;
    }

    public CarType getCarType() {
        return carType;
    }

    public void setCarType(CarType carType) {
        this.carType = carType;
    }

    public String getParkPlace() {
        return parkPlace;
    }

    public void setParkPlace(String parkPlace) {
        this.parkPlace = parkPlace;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Date getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(Date entryTime) {
        this.entryTime = entryTime;
    }

    public Date getLeaveTime() {
        return leaveTime;
    }

    public void setLeaveTime(Date leaveTime) {
        this.leaveTime = leaveTime;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id='" + id + '\'' +
                ", licensePlateNumber='" + licensePlateNumber + '\'' +
                ", carType=" + carType +
                ", parkPlace='" + parkPlace + '\'' +
                ", status=" + status +
                ", entryTime=" + entryTime +
                ", leaveTime=" + leaveTime +
                ", money=" + money +
                '}';
    }
}
