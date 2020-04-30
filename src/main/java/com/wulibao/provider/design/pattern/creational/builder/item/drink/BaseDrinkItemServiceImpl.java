package com.wulibao.provider.test.design.pattern.creational.builder.item.drink;

import com.wulibao.provider.test.design.pattern.creational.builder.item.ItemService;
import com.wulibao.provider.test.design.pattern.creational.builder.item.pack.PackService;
import com.wulibao.provider.test.design.pattern.creational.builder.item.pack.impl.CupPackServiceImpl;

/**
 * @author WuliBao
 * @date 2020-04-27
 */
public abstract class BaseDrinkItemServiceImpl implements ItemService {
    
    @Override
    public PackService pack() {
        return new CupPackServiceImpl();
    }
}
