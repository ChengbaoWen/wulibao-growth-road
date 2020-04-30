package com.wulibao.provider.test.design.pattern.structural.bridge.color.service.impl;

import com.wulibao.provider.test.design.pattern.structural.bridge.color.service.ColorService;

/**
 * @author WuliBao
 * @date 2020-04-28
 */
public class RedColorServiceImpl implements ColorService {
    @Override
    public void printColor() {
        System.out.println("红色");
    }
}
