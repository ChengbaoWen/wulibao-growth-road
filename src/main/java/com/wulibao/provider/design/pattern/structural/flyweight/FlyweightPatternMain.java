package com.wulibao.provider.design.pattern.structural.flyweight;

import com.wulibao.provider.design.pattern.structural.flyweight.color.ColorFactory;
import com.wulibao.provider.design.pattern.structural.flyweight.color.service.impl.ColorImpl;

/**
 * 享元模式
 * 
 * @author WuliBao
 * @date 2020-04-29
 */
public class FlyweightPatternMain {
    public static void main(String[] args) {
        ColorImpl color = (ColorImpl) ColorFactory.getColor("红色");
        color.setColor("蓝色");
        color.draw();
    }
}
