package com.wulibao.provider.test.design.pattern.creational.prototype.color;

import java.io.Serializable;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @author WuliBao
 * @date 2020-04-27
 */
@Data
@Slf4j
public class Color implements Serializable, Cloneable {
    
    private static final long serialVersionUID = 2393269568666085258L;
    
    private String color;
    
    public void drew() {
        System.out.println("颜色：" + color);
    }
    
    public Color(String color) {
        this.color = color;
    }
    
    @Override
    public Color clone() {
        Color clone = null;
        try {
            clone = (Color)super.clone();
        }
        catch (CloneNotSupportedException e) {
            log.error(e.getMessage());
        }
        return clone;
    }
}
