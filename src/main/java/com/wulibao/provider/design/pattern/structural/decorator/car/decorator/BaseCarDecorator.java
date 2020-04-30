package com.wulibao.provider.design.pattern.structural.decorator.car.decorator;

import com.wulibao.provider.design.pattern.structural.decorator.car.service.Car;

/**
 * @author WuliBao
 * @date 2020-04-28
 */
public abstract class BaseCarDecorator implements Car {
    private final Car car;
    
    protected BaseCarDecorator(Car car) {
        this.car = car;
    }
    
    @Override
    public void printCar() {
        car.printCar();
    }
}
