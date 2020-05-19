package com.wulibao.provider.design.pattern.behavioral.template.draw;

/**
 * 画一个红色的圆
 * 
 * @author WuliBao
 * @date 2020-05-19
 */
public class RedCircularDraw extends BaseDraw {
    @Override
    String getColor() {
        return "红色";
    }
    
    @Override
    String getShape() {
        return "圆形";
    }
}
