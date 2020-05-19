package com.wulibao.provider.design.pattern.behavioral.strategy;

import com.wulibao.provider.design.pattern.behavioral.strategy.strategy.Context;

/**
 * 策略模式
 * 
 * @author WuliBao
 * @date 2020-05-19
 */
public class StrategyPatternMain {
    public static void main(String[] args) {
        Context context = new Context();
        context.doAction(1, 2, "-");
    }
}
