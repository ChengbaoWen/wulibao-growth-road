package com.wulibao.provider.test.design.pattern.creational.builder.item.pack.impl;

import com.wulibao.provider.test.design.pattern.creational.builder.item.pack.PackService;

/**
 * @author WuliBao
 * @date 2020-04-27
 */
public class CupPackServiceImpl implements PackService {
    @Override
    public String packName() {
        return "杯子";
    }
}
