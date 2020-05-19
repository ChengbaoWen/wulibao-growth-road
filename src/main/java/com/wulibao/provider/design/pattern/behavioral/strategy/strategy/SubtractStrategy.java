package com.wulibao.provider.design.pattern.behavioral.strategy.strategy;

/**
 * @author WuliBao
 * @date 2020-05-19
 */
public class SubtractStrategy implements Strategy {
    @Override
    public int doAction(int a, int b) {
        return a - b;
    }
}
