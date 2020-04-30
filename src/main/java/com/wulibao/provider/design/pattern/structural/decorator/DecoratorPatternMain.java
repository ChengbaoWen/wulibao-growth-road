package com.wulibao.provider.test.design.pattern.structural.decorator;

import com.wulibao.provider.test.design.pattern.structural.decorator.car.decorator.SedanCarDecorator;
import com.wulibao.provider.test.design.pattern.structural.decorator.car.service.impl.SedanCar;

/**
 * 装饰器模式
 * 
 * @author WuliBao
 * @date 2020-04-28
 */
public class DecoratorPatternMain {
    public static void main(String[] args) {
        // 装饰前的小轿车
        SedanCar sedanCar = new SedanCar();
        sedanCar.printCar();
        // 装饰后的小轿车
        SedanCarDecorator sedanCarDecorator = new SedanCarDecorator(sedanCar);
        sedanCarDecorator.printCar();
        
    }
}
