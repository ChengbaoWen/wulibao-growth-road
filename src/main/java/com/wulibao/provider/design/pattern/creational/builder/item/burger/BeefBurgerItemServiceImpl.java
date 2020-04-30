package com.wulibao.provider.test.design.pattern.creational.builder.item.burger;

/**
 * @author WuliBao
 * @date 2020-04-27
 */
public class BeefBurgerItemServiceImpl extends BaseBurgerItemServiceImpl {
    @Override
    public String itemName() {
        return "牛肉堡";
    }
    
    @Override
    public double price() {
        return 10.5;
    }
}
