package com.wulibao.provider.design.pattern.structural.flyweight.color;

import com.wulibao.provider.design.pattern.structural.flyweight.color.service.Color;
import com.wulibao.provider.design.pattern.structural.flyweight.color.service.impl.ColorImpl;

import java.util.HashMap;

/**
 * 享元模式
 * 
 * @author WuliBao
 * @date 2020-04-29
 */
public class ColorFactory {
    private static final HashMap<String, Color> COLORS = new HashMap<>();
    
    public static Color getColor(String color) {
        Color c = COLORS.get(color);
        if (c == null) {
            ColorImpl colorImpl = new ColorImpl();
            colorImpl.setColor(color);
            COLORS.put(color, colorImpl);
            c = colorImpl;
        }
        return c;
    }
}
