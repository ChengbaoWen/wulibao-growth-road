package com.wulibao.provider.design.pattern.creational.abstracted.factory.suit.impl;

import com.wulibao.provider.design.pattern.creational.abstracted.factory.clothes.ClothesService;
import com.wulibao.provider.design.pattern.creational.abstracted.factory.clothes.impl.RedClothesServiceImpl;
import com.wulibao.provider.design.pattern.creational.abstracted.factory.shoes.impl.RedShoseServiceImpl;
import com.wulibao.provider.design.pattern.creational.abstracted.factory.shoes.ShoseService;
import com.wulibao.provider.design.pattern.creational.abstracted.factory.suit.SuitService;
import com.wulibao.provider.design.pattern.creational.abstracted.factory.trousers.impl.RedTrousersServiceImpl;
import com.wulibao.provider.design.pattern.creational.abstracted.factory.trousers.TrousersService;

/**
 * @author WuliBao
 * @date 2020-04-26
 */
public class SuitTwoServiceImpl implements SuitService {
    @Override
    public ClothesService getClothes() {
        return new RedClothesServiceImpl();
    }
    
    @Override
    public TrousersService getTrousers() {
        return new RedTrousersServiceImpl();
    }
    
    @Override
    public ShoseService getShoes() {
        return new RedShoseServiceImpl();
    }
}
