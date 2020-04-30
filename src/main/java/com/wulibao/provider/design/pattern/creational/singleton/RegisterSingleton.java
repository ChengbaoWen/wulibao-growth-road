package com.wulibao.provider.test.design.pattern.creational.singleton;

/**
 * 登记式/静态内部类，线程安全
 * 
 * @author WuliBao
 * @date 2020-04-26
 */
public class RegisterSingleton {
    
    private RegisterSingleton() {
        
    }
    
    public void print() {
        System.out.println("登记式/静态内部类，线程安全");
    }
    
    public static RegisterSingleton getInstance() {
        return SingletonHolder.INSTANCE;
    }
    
    private static class SingletonHolder {
        private static final RegisterSingleton INSTANCE = new RegisterSingleton();
    }
}
