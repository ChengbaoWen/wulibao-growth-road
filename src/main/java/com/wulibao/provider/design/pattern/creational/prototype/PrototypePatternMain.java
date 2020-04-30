package com.wulibao.provider.test.design.pattern.creational.prototype;

import com.wulibao.provider.test.design.pattern.creational.prototype.color.Color;
import com.wulibao.provider.test.design.pattern.creational.prototype.color.ColorCloneFactory;

/**
 * 原型模式
 * 
 * @author WuliBao
 * @date 2020-04-27
 */
public class PrototypePatternMain {
    public static void main(String[] args) {
        Color red1 = ColorCloneFactory.getColor("red");
        if (red1 != null) {
            red1.drew();
            red1.setColor("green");
            red1.drew();
        }
        Color red2 = ColorCloneFactory.getColor("red");
        if (red2 != null) {
            red2.drew();
        }
        
        Color blue = ColorCloneFactory.getColor("blue");
        if (blue != null) {
            blue.drew();
        }
        Color green = ColorCloneFactory.getColor("green");
        if (green != null) {
            green.drew();
        }
    }
}
