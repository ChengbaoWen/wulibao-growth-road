package com.wulibao.provider.design.pattern.behavioral.command;

import com.wulibao.provider.design.pattern.behavioral.command.order.Broker;
import com.wulibao.provider.design.pattern.behavioral.command.order.service.impl.DeleteStudent;
import com.wulibao.provider.design.pattern.behavioral.command.order.service.impl.InsertStudent;

/**
 * 命令模式
 * 
 * @author WuliBao
 * @date 2020-04-29
 */
public class CommandPatternMain {
    public static void main(String[] args) {
        Broker broker = new Broker();
        broker.addOrder(new InsertStudent(1, "小明"));
        broker.addOrder(new DeleteStudent(1));
        broker.execute();
    }
}
