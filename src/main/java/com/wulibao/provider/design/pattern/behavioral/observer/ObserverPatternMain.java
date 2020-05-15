package com.wulibao.provider.design.pattern.behavioral.observer;

import com.wulibao.provider.design.pattern.behavioral.observer.observer.HangZhouObserver;
import com.wulibao.provider.design.pattern.behavioral.observer.observer.JinLinObserver;
import com.wulibao.provider.design.pattern.behavioral.observer.subject.CenterSubject;

/**
 * 观察者模式
 * 
 * @author WuliBao
 * @date 2020-05-15
 */
public class ObserverPatternMain {
    public static void main(String[] args) {
        // 创建吉林观测台(观察者)
        JinLinObserver jinLinObserver = new JinLinObserver();
        // 创建杭州观测台(观察者)
        HangZhouObserver hangZhouObserver = new HangZhouObserver();
        // 创建中央气象台(被观察者)
        CenterSubject subject = CenterSubject.builder().temperature(23).build();
        // 讲吉林、杭州观测台加入到观察者集合中
        subject.registerObserver(jinLinObserver).registerObserver(hangZhouObserver);
        // 定义气温
        Integer temperature = 24;
        // 中央气象台的气温修改为24度,并通知所有观察者
        System.out.println("中央气象台的气温修改为:" + temperature);
        subject.updateTemperature(temperature);
    }
}
