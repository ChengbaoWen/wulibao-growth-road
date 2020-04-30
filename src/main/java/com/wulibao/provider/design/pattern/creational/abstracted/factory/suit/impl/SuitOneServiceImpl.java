package com.wulibao.provider.design.pattern.creational.abstracted.factory.suit.impl;

import com.wulibao.provider.design.pattern.creational.abstracted.factory.clothes.impl.BlueClothesServiceImpl;
import com.wulibao.provider.design.pattern.creational.abstracted.factory.clothes.ClothesService;
import com.wulibao.provider.design.pattern.creational.abstracted.factory.shoes.impl.BlueShoseServiceImpl;
import com.wulibao.provider.design.pattern.creational.abstracted.factory.shoes.ShoseService;
import com.wulibao.provider.design.pattern.creational.abstracted.factory.suit.SuitService;
import com.wulibao.provider.design.pattern.creational.abstracted.factory.trousers.impl.BlueTrousersServiceImpl;
import com.wulibao.provider.design.pattern.creational.abstracted.factory.trousers.TrousersService;

/**
 * @author WuliBao
 * @date 2020-04-26
 */
public class SuitOneServiceImpl implements SuitService {
    @Override
    public ClothesService getClothes() {
        return new BlueClothesServiceImpl();
    }
    
    @Override
    public TrousersService getTrousers() {
        return new BlueTrousersServiceImpl();
    }
    
    @Override
    public ShoseService getShoes() {
        return new BlueShoseServiceImpl();
    }
}
