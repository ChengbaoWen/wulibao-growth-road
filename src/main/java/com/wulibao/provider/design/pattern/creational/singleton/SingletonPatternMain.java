package com.wulibao.provider.design.pattern.creational.singleton;

/**
 * 单例模式
 * 
 * @author WuliBao
 * @date 2020-04-26
 */
public class SingletonPatternMain {
    public static void main(String[] args) {
        // 懒汉式，线程不安全
        SlovenlySingletonOne.getInstance().print();
        // 懒汉式，线程安全(获取实例方法加上同步锁)
        SlovenlySingletonTwo.getInstance().print();
        // 懒汉式，线程安全,双重校验
        SlovenlySingletonThree.getInstance().print();
        // 饿汉式，线程安全
        HungrySingleton.getInstance().print();
        // 登记式/静态内部类，线程安全
        RegisterSingleton.getInstance().print();
        // 枚举式，线程安全
        EnumSingleton.INSTANCE.print();
    }
}
