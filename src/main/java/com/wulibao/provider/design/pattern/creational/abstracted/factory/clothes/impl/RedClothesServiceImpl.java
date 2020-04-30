package com.wulibao.provider.design.pattern.creational.abstracted.factory.clothes.impl;

import com.wulibao.provider.design.pattern.creational.abstracted.factory.clothes.ClothesService;

/**
 * @author WuliBao
 * @date 2020-04-26
 */
public class RedClothesServiceImpl implements ClothesService {
    @Override
    public void printClothes() {
        System.out.println("红色的衣服");
    }
}
