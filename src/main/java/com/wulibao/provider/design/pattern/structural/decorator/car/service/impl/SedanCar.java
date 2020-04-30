package com.wulibao.provider.design.pattern.structural.decorator.car.service.impl;

import com.wulibao.provider.design.pattern.structural.decorator.car.service.Car;

/**
 * @author WuliBao
 * @date 2020-04-28
 */
public class SedanCar implements Car {
    @Override
    public void printCar() {
        System.out.println("小轿车");
    }
}
