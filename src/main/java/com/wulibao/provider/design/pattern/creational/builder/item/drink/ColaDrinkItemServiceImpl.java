package com.wulibao.provider.design.pattern.creational.builder.item.drink;

/**
 * @author WuliBao
 * @date 2020-04-27
 */
public class ColaDrinkItemServiceImpl extends BaseDrinkItemServiceImpl {
    @Override
    public String itemName() {
        return "可乐";
    }
    
    @Override
    public double price() {
        return 3.5;
    }
}
