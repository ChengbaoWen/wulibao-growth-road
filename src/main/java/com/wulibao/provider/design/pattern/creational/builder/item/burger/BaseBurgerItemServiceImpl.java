package com.wulibao.provider.test.design.pattern.creational.builder.item.burger;

import com.wulibao.provider.test.design.pattern.creational.builder.item.ItemService;
import com.wulibao.provider.test.design.pattern.creational.builder.item.pack.PackService;
import com.wulibao.provider.test.design.pattern.creational.builder.item.pack.impl.WrapperPackServiceImpl;

/**
 * @author WuliBao
 * @date 2020-04-27
 */
public abstract class BaseBurgerItemServiceImpl implements ItemService {
    
    @Override
    public PackService pack() {
        return new WrapperPackServiceImpl();
    }
}
