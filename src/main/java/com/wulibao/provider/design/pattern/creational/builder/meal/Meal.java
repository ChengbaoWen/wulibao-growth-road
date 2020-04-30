package com.wulibao.provider.test.design.pattern.creational.builder.meal;

import java.util.ArrayList;
import java.util.List;

import com.wulibao.provider.test.design.pattern.creational.builder.item.ItemService;

/**
 * @author WuliBao
 * @date 2020-04-27
 */
public class Meal {
    /**
     * 套餐名称
     */
    private final String mealName;
    
    /**
     * 食物列表
     */
    private final List<ItemService> itemList;
    
    private Meal(Builder builder) {
        this.mealName = builder.mealName;
        this.itemList = builder.itemList;
    }
    
    /**
     * 食物清单
     * 
     */
    public void getItemList() {
        System.out.println("套餐：" + mealName);
        itemList.forEach(
            item -> System.out.println(item.itemName() + "，" + item.pack().packName() + "，单价：" + item.price()));
        double cost = itemList.stream().mapToDouble(ItemService::price).sum();
        System.out.println("总计：" + cost);
    }
    
    public static class Builder {
        private final String mealName;
        
        private final List<ItemService> itemList;
        
        public Builder(String mealName) {
            this.mealName = mealName;
            this.itemList = new ArrayList<>();
        }
        
        public Builder addItem(ItemService item) {
            this.itemList.add(item);
            return this;
        }
        
        public Meal build() {
            return new Meal(this);
        }
        
    }
}
