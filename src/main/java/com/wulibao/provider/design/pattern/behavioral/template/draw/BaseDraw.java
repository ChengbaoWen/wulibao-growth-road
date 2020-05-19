package com.wulibao.provider.design.pattern.behavioral.template.draw;

/**
 * 画画模板方法
 * 
 * @author WuliBao
 * @date 2020-05-19
 */
public abstract class BaseDraw {
    
    /**
     * 颜色
     * 
     * @return String
     */
    abstract String getColor();
    
    /**
     * 形状
     * 
     * @return String
     */
    abstract String getShape();
    
    /**
     * 画画
     */
    public final void draw() {
        String color = getColor();
        String shape = getShape();
        System.out.println("画了一个" + color + "的" + shape);
    }
}
