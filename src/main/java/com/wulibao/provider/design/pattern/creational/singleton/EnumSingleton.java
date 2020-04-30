package com.wulibao.provider.design.pattern.creational.singleton;

/**
 * 枚举式，线程安全
 * 
 * @author WuliBao
 * @date 2020-04-26
 */
public enum EnumSingleton {
    /**
     * 实例
     */
    INSTANCE;
    
    public void print() {
        System.out.println("枚举式，线程安全");
    }
}
