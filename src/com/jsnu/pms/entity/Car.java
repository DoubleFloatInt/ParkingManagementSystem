package com.jsnu.pms.entity;

import java.util.Date;

/**
 * 车，用户存储汽车的订单编号，车牌号，进入和离开时间及对其收费金额
 * @author 李广帅
 * @Date 2020/4/3 4:44 下午
 */
public class Car {

    // 订单编号
    private String id;

    // 车牌号
    private String licensePlateNumber;

    // 进入时间
    private Date entryTIme;

    // 离开时间
    private Date leaveTime;

    // 收费金额
    private Double money;

    public Car() {
    }

    public Car(String id, String licensePlateNumber, Date entryTIme, Date leaveTime, Double money) {
        this.id = id;
        this.licensePlateNumber = licensePlateNumber;
        this.entryTIme = entryTIme;
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

    public Date getEntryTIme() {
        return entryTIme;
    }

    public void setEntryTIme(Date entryTIme) {
        this.entryTIme = entryTIme;
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
                "编号='" + id + '\'' +
                ", 车牌号='" + licensePlateNumber + '\'' +
                ", 进入时间=" + entryTIme +
                ", 离开时间=" + leaveTime +
                ", 金额=" + money +
                '}';
    }
}
