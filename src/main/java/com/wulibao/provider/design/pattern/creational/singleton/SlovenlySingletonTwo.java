package com.wulibao.provider.test.design.pattern.creational.singleton;

/**
 * 懒汉式，线程安全
 * 
 * @author WuliBao
 * @date 2020-04-26
 */
public class SlovenlySingletonTwo {
    private volatile static SlovenlySingletonTwo instance = null;
    
    private SlovenlySingletonTwo() {
        
    }
    
    public void print() {
        System.out.println("懒汉式，线程安全");
    }
    
    public static synchronized SlovenlySingletonTwo getInstance() {
        if (instance == null) {
            instance = new SlovenlySingletonTwo();
        }
        return instance;
    }
}
