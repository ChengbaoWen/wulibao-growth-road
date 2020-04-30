package com.wulibao.provider.test.design.pattern.creational.abstracted.factory.shoes.impl;

import com.wulibao.provider.test.design.pattern.creational.abstracted.factory.shoes.ShoseService;

/**
 * @author WuliBao
 * @date 2020-04-26
 */
public class BlueShoseServiceImpl implements ShoseService {
    @Override
    public void printShose() {
        System.out.println("蓝色的鞋子");
    }
}
