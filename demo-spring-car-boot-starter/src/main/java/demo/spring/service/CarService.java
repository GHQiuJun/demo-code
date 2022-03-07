package demo.spring.service;

import demo.spring.entity.Car;

/**
 * car功能模块 获取car 和 设置 car
 * @author junqiu
 */
public class CarService {
    private Car car;

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
