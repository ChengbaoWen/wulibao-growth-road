package com.wulibao.provider.design.pattern.structural.bridge.color;

import com.wulibao.provider.design.pattern.structural.bridge.color.service.ColorService;

/**
 * @author WuliBao
 * @date 2020-04-28
 */
public class DrawColor extends BaseDrawColor {
    private final String mark;
    
    public DrawColor(String mark, ColorService colorService) {
        super(colorService);
        this.mark = mark;
    }
    
    @Override
    public void draw() {
        System.out.println(mark);
        super.getService().printColor();
    }
}
