package com.jsnu.pms.data;

import com.jsnu.pms.entity.Car;

/**
 * @author 李广帅
 * @Date 2020/4/5 2:14 下午
 */
public class CarNode {
    private CarNode prev;
    private CarNode next;
    private Car data;

    public CarNode() {
    }

    public CarNode(CarNode prev, CarNode next, Car data) {
        this.prev = prev;
        this.next = next;
        this.data = data;
    }

    public CarNode getPrev() {
        return prev;
    }

    public void setPrev(CarNode prev) {
        this.prev = prev;
    }

    public CarNode getNext() {
        return next;
    }

    public void setNext(CarNode next) {
        this.next = next;
    }

    public Car getData() {
        return data;
    }

    public void setData(Car data) {
        this.data = data;
    }
}
