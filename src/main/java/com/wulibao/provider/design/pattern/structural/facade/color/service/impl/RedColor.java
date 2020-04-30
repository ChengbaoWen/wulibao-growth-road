package com.wulibao.provider.design.pattern.structural.facade.color.service.impl;

import com.wulibao.provider.design.pattern.structural.facade.color.service.ColorDraw;

/**
 * @author WuliBao
 * @date 2020-04-29
 */
public class RedColor implements ColorDraw {
    @Override
    public void draw() {
        System.out.println("红色");
    }
}
