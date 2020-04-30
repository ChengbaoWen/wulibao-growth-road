package com.wulibao.provider.design.pattern.structural.facade.color;

import com.wulibao.provider.design.pattern.structural.facade.color.service.ColorDraw;
import com.wulibao.provider.design.pattern.structural.facade.color.service.impl.BlueColor;
import com.wulibao.provider.design.pattern.structural.facade.color.service.impl.RedColor;

/**
 * @author WuliBao
 * @date 2020-04-29
 */
public class ColorFacade {
    private final ColorDraw red;
    
    private final ColorDraw blue;
    
    public ColorFacade() {
        this.red = new RedColor();
        this.blue = new BlueColor();
    }
    
    public void drawRed() {
        red.draw();
    }
    
    public void drawBlue() {
        blue.draw();
    }
}
