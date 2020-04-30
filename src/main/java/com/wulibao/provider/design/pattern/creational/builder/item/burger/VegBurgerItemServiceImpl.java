package com.wulibao.provider.design.pattern.creational.builder.item.burger;

/**
 * @author WuliBao
 * @date 2020-04-27
 */
public class VegBurgerItemServiceImpl extends BaseBurgerItemServiceImpl {
    @Override
    public String itemName() {
        return "鸡腿堡";
    }
    
    @Override
    public double price() {
        return 12.5;
    }
}
