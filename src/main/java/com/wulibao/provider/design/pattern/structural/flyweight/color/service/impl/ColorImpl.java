package com.wulibao.provider.design.pattern.structural.flyweight.color.service.impl;

import com.wulibao.provider.design.pattern.structural.flyweight.color.service.Color;

/**
 * @author WuliBao
 * @date 2020-04-29
 */
public class ColorImpl implements Color {
    private String color;
    
    public void setColor(String color) {
        this.color = color;
    }
    
    @Override
    public void draw() {
        System.out.println("画出" + color + "颜色");
    }
}
