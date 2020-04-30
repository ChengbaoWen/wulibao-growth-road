package com.wulibao.provider.design.pattern.structural.proxy.dance.service.impl;

import com.wulibao.provider.design.pattern.structural.proxy.dance.service.Dance;

/**
 * @author WuliBao
 * @date 2020-04-29
 */
public class DanceImpl implements Dance {
    @Override
    public void dance() {
        System.out.println("跳一支芭蕾舞");
    }
}
