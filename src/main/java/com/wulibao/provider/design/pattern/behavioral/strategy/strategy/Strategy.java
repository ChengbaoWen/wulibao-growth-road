package com.wulibao.provider.design.pattern.behavioral.strategy.strategy;

/**
 * 策略顶级接口
 * 
 * @author WuliBao
 * @date 2020-05-19
 */
public interface Strategy {
    /**
     * 运算方法
     * 
     * @param a a
     * @param b b
     * @return int
     */
    int doAction(int a, int b);
}
