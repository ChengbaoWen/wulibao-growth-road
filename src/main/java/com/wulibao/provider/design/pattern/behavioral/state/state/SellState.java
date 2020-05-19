package com.wulibao.provider.design.pattern.behavioral.state.state;

import com.wulibao.provider.design.pattern.behavioral.state.Context;

/**
 * @author WuliBao
 * @date 2020-05-19
 */
public class SellState implements BaseState {
    
    @Override
    public void insertCoin(int coin, Context context) {
        // 设置投币的数量
        context.setCoinNum(context.getCoinNum() + coin);
        System.out.println("您的硬币数量:" + context.getCoinNum());
    }
    
    @Override
    public void sell(Context context) {
        // 扣币-1
        System.out.println("正在扣币");
        if (context.getCoinNum() > 0) {
            context.setCoinNum(context.getCoinNum() - 1);
        }
        System.out.println("正在售货");
        System.out.println("出货成功");
        // 如果有币，转换成有币状态
        if (context.getCoinNum() > 0) {
            context.setState(new HaveCoinState());
        }
        // 如果没有硬币则为初始化状态
        else {
            context.setState(new InitializationState());
        }
    }
    
    @Override
    public void outCoin(Context context) {
        System.out.println("正在出货，无法退币");
    }
}
