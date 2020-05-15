package com.wulibao.provider.design.pattern.behavioral.observer.subject;

import java.util.HashSet;
import java.util.Set;

import com.wulibao.provider.design.pattern.behavioral.observer.observer.BaseObserver;

/**
 * 被观察者的顶级抽象类，主要负责 观察者的注册，移除，通知
 * 
 * @author WuliBao
 * @date 2020-05-15
 */
public abstract class BaseSubject<T> {
    /**
     * 观察者集合
     */
    private final Set<BaseObserver<T>> observers = new HashSet<>();
    
    /**
     * 注册观察者
     * 
     * @param observer observer
     */
    public BaseSubject<T> registerObserver(BaseObserver<T> observer) {
        observers.add(observer);
        return this;
    }
    
    /**
     * 移除观察者
     * 
     * @param observer observer
     */
    public void removeObserver(BaseObserver<T> observer) {
        observers.remove(observer);
    }
    
    /**
     * 发生改变通知所有观察者
     */
    protected void notifyAllObservers(T o) {
        observers.forEach(observer -> observer.update(o));
    }
}
