package com.wulibao.provider.test.design.pattern.creational.abstracted.factory.clothes.impl;

import com.wulibao.provider.test.design.pattern.creational.abstracted.factory.clothes.ClothesService;

/**
 * @author WuliBao
 * @date 2020-04-26
 */
public class BlueClothesServiceImpl implements ClothesService {
    @Override
    public void printClothes() {
        System.out.println("蓝色的衣服");
    }
}
