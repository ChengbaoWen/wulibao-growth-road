package com.wulibao.provider.design.pattern.creational.singleton;

/**
 * 饿汉式，线程安全
 * 
 * @author WuliBao
 * @date 2020-04-26
 */
public class HungrySingleton {
    private static final HungrySingleton INSTANCE = new HungrySingleton();
    
    private HungrySingleton() {
        
    }
    
    public static HungrySingleton getInstance() {
        return INSTANCE;
    }
    
    public void print() {
        System.out.println("饿汉式，线程安全");
    }
}
