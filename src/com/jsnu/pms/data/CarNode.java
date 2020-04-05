package com.jsnu.pms.data;

import com.jsnu.pms.entity.Car;

/**
 * @author 李广帅
 * @Date 2020/4/5 2:14 下午
 */
public class CarNode {
    private Car prev;
    private Car next;
    private Car data;

    public CarNode() {
    }

    public CarNode(Car prev, Car next, Car data) {
        this.prev = prev;
        this.next = next;
        this.data = data;
    }

    public Car getPrev() {
        return prev;
    }

    public void setPrev(Car prev) {
        this.prev = prev;
    }

    public Car getNext() {
        return next;
    }

    public void setNext(Car next) {
        this.next = next;
    }

    public Car getData() {
        return data;
    }

    public void setData(Car data) {
        this.data = data;
    }
}
