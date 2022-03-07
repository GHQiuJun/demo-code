package com.demo.spi;

import demo.spring.entity.Car;
import demo.spring.service.CarService;
import org.springframework.stereotype.Service;

/**
 * @author junqiu
 */
@Service
public class SpringSpiTestService {

    private final CarService carService;

    public SpringSpiTestService(CarService carService) {
        this.carService = carService;
    }

    void test(){
        System.out.println(carService);
        Car car = carService.getCar();
        System.out.println(car);
        System.out.println(car.name);
    }

}
