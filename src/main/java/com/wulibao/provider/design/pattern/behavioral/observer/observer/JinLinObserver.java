package com.wulibao.provider.design.pattern.behavioral.observer.observer;

/**
 * 吉林气象台报告厅
 * 
 * @author WuliBao
 * @date 2020-05-15
 */
public class JinLinObserver implements BaseObserver<Integer> {
    @Override
    public void update(Integer temperature) {
        System.out.println("吉林气象台收到预警信息,气温发生改变:" + temperature);
    }
}
