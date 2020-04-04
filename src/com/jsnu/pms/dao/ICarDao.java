package com.jsnu.pms.dao;

import com.jsnu.pms.entity.Car;

/**
 * @author 李广帅
 * @Date 2020/4/4 6:15 下午
 */
public interface ICarDao {
    /**
     * 添加停车信息
     * @param car
     */
    public void addCar(Car car);


    /**
     * 删除停车信息
     */
    public void deleteCar();




}
