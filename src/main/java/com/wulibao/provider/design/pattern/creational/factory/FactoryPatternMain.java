package com.wulibao.provider.test.design.pattern.creational.factory;

import com.wulibao.provider.test.design.pattern.creational.factory.color.impl.BlueServiceImpl;
import com.wulibao.provider.test.design.pattern.creational.factory.color.ColorService;
import com.wulibao.provider.test.design.pattern.creational.factory.color.impl.RedServiceImpl;

/**
 * 工厂设计模式
 * 
 * @author WuliBao
 * @date 2020-04-24
 */
public class FactoryPatternMain {
    public static void main(String[] args) {
        ColorService red = new RedServiceImpl();
        red.printColor();
        ColorService blue = new BlueServiceImpl();
        blue.printColor();
    }
}
