package com.wulibao.provider.design.pattern.behavioral.state.state;

import com.wulibao.provider.design.pattern.behavioral.state.Context;

/**
 * @author WuliBao
 * @date 2020-05-18
 */
public interface BaseState {
    
    /**
     * 投币
     * 
     * @param coin coin
     * @param context context
     */
    void insertCoin(int coin, Context context);
    
    /**
     * 出售
     * 
     * @param context context
     */
    void sell(Context context);
    
    /**
     * 退币
     * 
     * @param context context
     */
    void outCoin(Context context);
}
