package com.wulibao.provider.test.design.pattern.creational.builder.item;

import com.wulibao.provider.test.design.pattern.creational.builder.item.pack.PackService;

/**
 * @author WuliBao
 * @date 2020-04-27
 */
public interface ItemService {
    /**
     * 食物名称
     * 
     * @return String
     */
    String itemName();
    
    /**
     * 包装
     * 
     * @return PackService
     */
    PackService pack();
    
    /**
     * 价格
     * 
     * @return double
     */
    double price();
}
