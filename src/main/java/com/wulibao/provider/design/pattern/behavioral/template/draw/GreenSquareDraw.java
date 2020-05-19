package com.wulibao.provider.design.pattern.behavioral.template.draw;

/**
 * 画一个绿色的方形
 * 
 * @author WuliBao
 * @date 2020-05-19
 */
public class GreenSquareDraw extends BaseDraw {
    @Override
    String getColor() {
        return "绿色";
    }
    
    @Override
    String getShape() {
        return "方形";
    }
}
