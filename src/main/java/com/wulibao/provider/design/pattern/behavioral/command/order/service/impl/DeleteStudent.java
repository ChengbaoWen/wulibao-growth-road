package com.wulibao.provider.design.pattern.behavioral.command.order.service.impl;

import com.wulibao.provider.design.pattern.behavioral.command.order.service.Order;

/**
 * @author WuliBao
 * @date 2020-04-30
 */
public class DeleteStudent implements Order {
    private final Integer num;
    
    public DeleteStudent(Integer num) {
        this.num = num;
    }
    
    @Override
    public void execute() {
        System.out.println("删除一个学生:" + num);
    }
}
