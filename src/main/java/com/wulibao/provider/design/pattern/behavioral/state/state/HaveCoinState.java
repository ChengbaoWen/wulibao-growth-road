package com.wulibao.provider.design.pattern.behavioral.state.state;

import com.wulibao.provider.design.pattern.behavioral.state.Context;

/**
 * @author WuliBao
 * @date 2020-05-19
 */
public class HaveCoinState implements BaseState {
    
    @Override
    public void insertCoin(int coin, Context context) {
        // 设置投币的数量
        context.setCoinNum(context.getCoinNum() + coin);
        System.out.println("您的硬币数量:" + context.getCoinNum());
    }
    
    @Override
    public void sell(Context context) {
        // 转换成售货状态
        context.setState(new SellState());
        context.sell();
    }
    
    @Override
    public void outCoin(Context context) {
        System.out.println("退还您的硬币数量:" + context.getCoinNum());
        // 转换成初始化状态
        context.setState(new InitializationState());
        // 剩余硬币数量为0
        context.setCoinNum(0);
    }
}
