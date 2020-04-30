package com.wulibao.provider.design.pattern.creational.builder;

import com.wulibao.provider.design.pattern.creational.builder.item.drink.CoffeeDrinkItemServiceImpl;
import com.wulibao.provider.design.pattern.creational.builder.meal.Meal;
import com.wulibao.provider.design.pattern.creational.builder.item.burger.BeefBurgerItemServiceImpl;
import com.wulibao.provider.design.pattern.creational.builder.item.burger.VegBurgerItemServiceImpl;
import com.wulibao.provider.design.pattern.creational.builder.item.drink.ColaDrinkItemServiceImpl;

/**
 * 建造者设计模式
 * 
 * @author WuliBao
 * @date 2020-04-26
 */
public class BuilderPatternMain {
    public static void main(String[] args) {
        // 套餐1
        Meal meal1 =
            // 建造者模式
            new Meal.Builder("超值早餐")
                // 套餐加入鸡腿堡
                .addItem(new VegBurgerItemServiceImpl())
                // 套餐加入可乐
                .addItem(new ColaDrinkItemServiceImpl())
                // 完成建造
                .build();
        // 套餐1清单
        meal1.getItemList();
        
        // 套餐2
        Meal meal2 = new Meal.Builder("豪华午餐")
            // 加入牛肉堡
            .addItem(new BeefBurgerItemServiceImpl())
            // 加入鸡腿堡
            .addItem(new VegBurgerItemServiceImpl())
            // 加入咖啡
            .addItem(new CoffeeDrinkItemServiceImpl())
            // 完成建造
            .build();
        // 套餐2清单
        meal2.getItemList();
        
    }
}
