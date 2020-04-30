package com.wulibao.provider.design.pattern.structural.bridge.color;

import com.wulibao.provider.design.pattern.structural.bridge.color.service.ColorService;

/**
 * @author WuliBao
 * @date 2020-04-28
 */
public abstract class BaseDrawColor {
    private final ColorService colorService;
    
    protected ColorService getService() {
        return colorService;
    }
    
    protected BaseDrawColor(ColorService colorService) {
        this.colorService = colorService;
    }
    
    /**
     * 绘画
     */
    abstract void draw();
}
