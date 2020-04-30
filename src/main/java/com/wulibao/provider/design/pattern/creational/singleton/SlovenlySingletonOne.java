package com.wulibao.provider.test.design.pattern.creational.singleton;

/**
 * 懒汉式，线程不安全
 * 
 * @author WuliBao
 * @date 2020-04-26
 */
public class SlovenlySingletonOne {
    private static SlovenlySingletonOne instance = null;
    
    private SlovenlySingletonOne() {
        
    }
    
    public void print() {
        System.out.println("懒汉式，线程不安全");
    }
    
    public static SlovenlySingletonOne getInstance() {
        if (instance == null) {
            instance = new SlovenlySingletonOne();
        }
        return instance;
    }
}
