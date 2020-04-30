package com.wulibao.provider.test.design.pattern.structural.facade;

import com.wulibao.provider.test.design.pattern.structural.facade.color.ColorFacade;

/**
 * 外观模式
 * 
 * @author WuliBao
 * @date 2020-04-28
 */
public class FacadePatternMain {
    public static void main(String[] args) {
        ColorFacade colorFacade = new ColorFacade();
        colorFacade.drawRed();
        colorFacade.drawBlue();
    }
}
