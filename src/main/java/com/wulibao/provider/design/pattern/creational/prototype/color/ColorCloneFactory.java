package com.wulibao.provider.design.pattern.creational.prototype.color;

import java.util.HashMap;
import java.util.Map;

import org.springframework.lang.NonNull;

import lombok.extern.slf4j.Slf4j;

/**
 * 原型模式，即克隆目标对象实现创建新的实例
 * 
 * @author WuliBao
 * @date 2020-04-27
 */
@Slf4j
public class ColorCloneFactory {
    
    private static final Map<String, Color> COLOR_MAP = new HashMap<>();
    
    static {
        COLOR_MAP.put("red", new Color("red"));
        COLOR_MAP.put("blue", new Color("blue"));
        COLOR_MAP.put("green", new Color("green"));
    }
    
    public static Color getColor(@NonNull String color) {
        if (COLOR_MAP.containsKey(color)) {
            // 序列化方式实现深度克隆对象
            Color c = COLOR_MAP.get(color);
            if (c != null) {
                // 序列化方式克隆对象
                // return CopyUtil.deep(c);
                return c.clone();
            }
        }
        return null;
    }
}
