package com.wulibao.provider.design.pattern.creational.abstracted.factory.suit;

import com.wulibao.provider.design.pattern.creational.abstracted.factory.clothes.ClothesService;
import com.wulibao.provider.design.pattern.creational.abstracted.factory.shoes.ShoseService;
import com.wulibao.provider.design.pattern.creational.abstracted.factory.trousers.TrousersService;

/**
 * @author WuliBao
 * @date 2020-04-26
 */
public interface SuitService {
    
    /**
     * 获取衣服
     */
    ClothesService getClothes();
    
    /**
     * 获取裤子
     */
    TrousersService getTrousers();
    
    /**
     * 获取鞋子
     */
    ShoseService getShoes();
}
