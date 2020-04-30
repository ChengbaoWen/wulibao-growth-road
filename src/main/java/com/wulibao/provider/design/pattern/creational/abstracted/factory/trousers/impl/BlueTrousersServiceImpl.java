package com.wulibao.provider.design.pattern.creational.abstracted.factory.trousers.impl;

import com.wulibao.provider.design.pattern.creational.abstracted.factory.trousers.TrousersService;

/**
 * @author WuliBao
 * @date 2020-04-26
 */
public class BlueTrousersServiceImpl implements TrousersService {
    @Override
    public void printTrousers() {
        System.out.println("蓝色的裤子");
    }
}
