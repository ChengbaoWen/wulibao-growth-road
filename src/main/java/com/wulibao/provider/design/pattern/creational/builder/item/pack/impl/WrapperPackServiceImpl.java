package com.wulibao.provider.design.pattern.creational.builder.item.pack.impl;

import com.wulibao.provider.design.pattern.creational.builder.item.pack.PackService;

/**
 * @author WuliBao
 * @date 2020-04-27
 */
public class WrapperPackServiceImpl implements PackService {
    @Override
    public String packName() {
        return "包装盒";
    }
}
