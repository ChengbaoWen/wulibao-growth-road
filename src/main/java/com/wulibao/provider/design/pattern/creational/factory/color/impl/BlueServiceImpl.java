package com.wulibao.provider.design.pattern.creational.factory.color.impl;

import com.wulibao.provider.design.pattern.creational.factory.color.ColorService;

/**
 * @author WuliBao
 * @date 2020-04-24
 */
public class BlueServiceImpl implements ColorService {
    @Override
    public void printColor() {
        System.out.println("蓝色");
    }
}
