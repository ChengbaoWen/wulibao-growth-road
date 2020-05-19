package com.wulibao.provider.design.pattern.behavioral.state.state;

import com.wulibao.provider.design.pattern.behavioral.state.Context;

/**
 * 初始化状态
 * 
 * @author WuliBao
 * @date 2020-05-18
 */
public class InitializationState implements BaseState {
    
    @Override
    public void insertCoin(int coin, Context context) {
        // 设置投币的数量
        context.setCoinNum(context.getCoinNum() + coin);
        System.out.println("您的硬币数量:" + context.getCoinNum());
        // 修改状态为有币状态
        context.setState(new HaveCoinState());
    }
    
    @Override
    public void sell(Context context) {
        System.out.println("请先投币");
    }
    
    @Override
    public void outCoin(Context context) {
        System.out.println("没有币可退");
    }
}
