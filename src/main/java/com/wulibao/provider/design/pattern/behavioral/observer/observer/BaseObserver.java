package com.wulibao.provider.design.pattern.behavioral.observer.observer;

/**
 * 观察者
 * 
 * 作用：所有观察员的顶级接口，封装公共观察者的接收通知的方法
 * 
 * @author WuliBao
 * @date 2020-05-15
 */
public interface BaseObserver<T> {
    /**
     * 观察者 收到 被观察者 已经发生改变的方法
     * 
     * @param o o
     */
    void update(T o);
}
