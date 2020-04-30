package com.wulibao.provider.design.pattern.behavioral.command.order.service.impl;

import com.wulibao.provider.design.pattern.behavioral.command.order.Student;
import com.wulibao.provider.design.pattern.behavioral.command.order.service.Order;

/**
 * @author WuliBao
 * @date 2020-04-30
 */
public class InsertStudent implements Order {
    private final Student student;
    
    public InsertStudent(Integer num, String name) {
        this.student = Student.builder().num(num).name(name).build();
    }
    
    @Override
    public void execute() {
        System.out.println("新增一个学生:" + student.toString());
    }
}
