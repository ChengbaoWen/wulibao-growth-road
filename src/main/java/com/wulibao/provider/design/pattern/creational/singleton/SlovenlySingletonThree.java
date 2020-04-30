package com.wulibao.provider.test.design.pattern.creational.singleton;

/**
 * 懒汉式，线程安全,双重校验
 * 
 * @author WuliBao
 * @date 2020-04-26
 */
public class SlovenlySingletonThree {
    private static SlovenlySingletonThree instance = null;
    
    private SlovenlySingletonThree() {
        
    }
    
    public void print() {
        System.out.println("懒汉式，线程安全,双重校验");
    }
    
    public static SlovenlySingletonThree getInstance() {
        if (instance == null) {
            synchronized (SlovenlySingletonThree.class) {
                if (instance == null) {
                    instance = new SlovenlySingletonThree();
                }
            }
        }
        return instance;
    }
}
