package com.wulibao.provider.design.pattern.behavioral.chain.responsibility.service.impl;

import com.wulibao.provider.design.pattern.behavioral.chain.responsibility.service.BaseAnimalChain;

/**
 * @author WuliBao
 * @date 2020-04-29
 */
public class MonkeyChain extends BaseAnimalChain {
    private static final String MONKEY = "猴子";
    
    @Override
    protected boolean cheAnimal(String animal) {
        System.out.println("猴子过滤器");
        if (MONKEY.equals(animal)) {
            System.out.println("这个动物是：" + MONKEY);
            return true;
        }
        return false;
    }
}
