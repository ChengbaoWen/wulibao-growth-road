package com.wulibao.provider.design.pattern.behavioral.state;

import com.wulibao.provider.design.pattern.behavioral.state.state.BaseState;
import com.wulibao.provider.design.pattern.behavioral.state.state.InitializationState;

import lombok.Data;

/**
 * 状态上下文对象
 * 
 * @author WuliBao
 * @date 2020-05-18
 */
@Data
public class Context {
    
    /**
     * 币的数量
     */
    private int coinNum;
    
    /**
     * 当前状态(默认为初始化状态)
     */
    private BaseState state = new InitializationState();
    
    /**
     * 投币
     * 
     * @param coin coin
     */
    public void insertCoin(int coin) {
        state.insertCoin(coin, this);
    }
    
    /**
     * 购买商品
     */
    public void sell() {
        state.sell(this);
    }
    
    /**
     * 退币
     */
    public void outCoin() {
        state.outCoin(this);
    }
}
