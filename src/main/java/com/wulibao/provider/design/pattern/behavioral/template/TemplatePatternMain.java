package com.wulibao.provider.design.pattern.behavioral.template;

import com.wulibao.provider.design.pattern.behavioral.template.draw.BaseDraw;
import com.wulibao.provider.design.pattern.behavioral.template.draw.GreenSquareDraw;
import com.wulibao.provider.design.pattern.behavioral.template.draw.RedCircularDraw;

/**
 * 模板模式
 * 
 * @author WuliBao
 * @date 2020-05-19
 */
public class TemplatePatternMain {
    public static void main(String[] args) {
        BaseDraw greenSquareDraw = new GreenSquareDraw();
        greenSquareDraw.draw();
        BaseDraw redCircularDraw = new RedCircularDraw();
        redCircularDraw.draw();
    }
}
