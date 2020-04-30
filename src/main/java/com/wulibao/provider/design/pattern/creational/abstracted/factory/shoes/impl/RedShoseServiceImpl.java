package com.wulibao.provider.design.pattern.creational.abstracted.factory.shoes.impl;

import com.wulibao.provider.design.pattern.creational.abstracted.factory.shoes.ShoseService;

/**
 * @author WuliBao
 * @date 2020-04-26
 */
public class RedShoseServiceImpl implements ShoseService {
    @Override
    public void printShose() {
        System.out.println("红色的鞋子");
    }
}
