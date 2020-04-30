package com.wulibao.provider.design.pattern.creational.abstracted.factory;

import com.wulibao.provider.design.pattern.creational.abstracted.factory.suit.SuitService;
import com.wulibao.provider.design.pattern.creational.abstracted.factory.suit.impl.SuitOneServiceImpl;
import com.wulibao.provider.design.pattern.creational.abstracted.factory.suit.impl.SuitTwoServiceImpl;

/**
 * 抽象工厂设计模式
 * 
 * @author WuliBao
 * @date 2020-04-26
 */
public class AbstractFactoryPatternMain {
    public static void main(String[] args) {
        SuitService a = new SuitOneServiceImpl();
        a.getClothes().printClothes();
        a.getTrousers().printTrousers();
        a.getShoes().printShose();
        SuitService b = new SuitTwoServiceImpl();
        b.getClothes().printClothes();
        b.getTrousers().printTrousers();
        b.getShoes().printShose();
    }
}
