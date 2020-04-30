package com.wulibao.provider.design.pattern.structural.proxy.dance;

import com.wulibao.provider.design.pattern.structural.proxy.dance.service.Dance;

/**
 * @author WuliBao
 * @date 2020-04-29
 */
public class ProxyDance implements Dance {
    private final Dance dance;
    
    public ProxyDance(Dance dance) {
        this.dance = dance;
    }
    
    @Override
    public void dance() {
        before();
        dance.dance();
        after();
    }
    
    private void before() {
        System.out.println("热个身");
    }
    
    private void after() {
        System.out.println("谢幕");
    }
}
