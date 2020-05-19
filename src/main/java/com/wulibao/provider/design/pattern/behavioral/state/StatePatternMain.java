package com.wulibao.provider.design.pattern.behavioral.state;

/**
 * 状态模式
 * 
 * @author WuliBao
 * @date 2020-05-15
 */
public class StatePatternMain {
    public static void main(String[] args) {
        Context context = new Context();
        context.sell();
        System.out.println("--当前状态：" + context.getState().getClass().getName());
        context.outCoin();
        System.out.println("--当前状态：" + context.getState().getClass().getName());
        context.insertCoin(1);
        System.out.println("--当前状态：" + context.getState().getClass().getName());
        context.outCoin();
        System.out.println("--当前状态：" + context.getState().getClass().getName());
        context.insertCoin(2);
        context.sell();
        context.outCoin();
        context.sell();
    }
}
