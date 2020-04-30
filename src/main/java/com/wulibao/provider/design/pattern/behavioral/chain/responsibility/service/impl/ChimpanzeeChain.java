package com.wulibao.provider.test.design.pattern.behavioral.chain.responsibility.service.impl;

import com.wulibao.provider.test.design.pattern.behavioral.chain.responsibility.service.BaseAnimalChain;

/**
 * @author WuliBao
 * @date 2020-04-29
 */
public class ChimpanzeeChain extends BaseAnimalChain {
    private static final String CHIMPANZEE = "猩猩";
    
    @Override
    protected boolean cheAnimal(String animal) {
        System.out.println("猩猩过滤器");
        if (CHIMPANZEE.equals(animal)) {
            System.out.println("这个动物是：" + CHIMPANZEE);
            return true;
        }
        return false;
    }
}
