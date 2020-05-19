package com.wulibao.provider.design.pattern.behavioral.strategy.strategy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author WuliBao
 * @date 2020-05-19
 */
public class Context {
    private final Map<String, Strategy> strategyMap;
    
    public Context() {
        strategyMap = new HashMap<>(2);
        strategyMap.put("+", new AddStrategy());
        strategyMap.put("-", new SubtractStrategy());
    }
    
    public void doAction(int a, int b, String operation) {
        Strategy strategy = strategyMap.get(operation);
        if (strategy == null) {
            System.out.println("错误的操作运算符");
        }
        else {
            int result = strategy.doAction(a, b);
            System.out.println("运算结果：" + result);
        }
    }
}
