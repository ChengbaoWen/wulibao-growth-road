package com.wulibao.provider.design.pattern.behavioral.chain.responsibility.service.impl;

import com.wulibao.provider.design.pattern.behavioral.chain.responsibility.service.BaseAnimalChain;

/**
 * @author WuliBao
 * @date 2020-04-29
 */
public class TigerChain extends BaseAnimalChain {
    private static final String TIGER = "老虎";
    
    @Override
    protected boolean cheAnimal(String animal) {
        System.out.println("老虎过滤器");
        if (TIGER.equals(animal)) {
            System.out.println("这个动物是：" + TIGER);
            return true;
        }
        return false;
    }
}
