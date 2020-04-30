package com.wulibao.provider.design.pattern.structural.proxy;

import com.wulibao.provider.design.pattern.structural.proxy.dance.ProxyDance;
import com.wulibao.provider.design.pattern.structural.proxy.dance.service.Dance;
import com.wulibao.provider.design.pattern.structural.proxy.dance.service.impl.DanceImpl;

/**
 * 代理模式
 * 
 * @author WuliBao
 * @date 2020-04-29
 */
public class ProxyPatternMain {
    public static void main(String[] args) {
        Dance dance = new ProxyDance(new DanceImpl());
        dance.dance();
    }
}
