package com.wulibao.provider.test.design.pattern.creational.abstracted.factory.trousers.impl;

import com.wulibao.provider.test.design.pattern.creational.abstracted.factory.trousers.TrousersService;

/**
 * @author WuliBao
 * @date 2020-04-26
 */
public class RedTrousersServiceImpl implements TrousersService {
    @Override
    public void printTrousers() {
        System.out.println("红色的裤子");
    }
}
