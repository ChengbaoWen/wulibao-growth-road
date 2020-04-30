package com.wulibao.provider.test.design.pattern.structural.decorator.car.decorator;

import com.wulibao.provider.test.design.pattern.structural.decorator.car.service.Car;

/**
 * @author WuliBao
 * @date 2020-04-28
 */
public class SedanCarDecorator extends BaseCarDecorator {
    public SedanCarDecorator(Car car) {
        super(car);
    }
    
    @Override
    public void printCar() {
        addPaint();
        super.printCar();
    }
    
    /**
     * 增加喷漆
     */
    private void addPaint() {
        System.out.println("增加红色喷漆");
    }
}
