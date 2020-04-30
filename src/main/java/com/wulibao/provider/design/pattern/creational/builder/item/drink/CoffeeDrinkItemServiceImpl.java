package com.wulibao.provider.design.pattern.creational.builder.item.drink;

/**
 * @author WuliBao
 * @date 2020-04-27
 */
public class CoffeeDrinkItemServiceImpl extends BaseDrinkItemServiceImpl {
    @Override
    public String itemName() {
        return "咖啡";
    }
    
    @Override
    public double price() {
        return 7.5;
    }
}
