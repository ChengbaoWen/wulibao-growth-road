package com.wulibao.provider.design.pattern.behavioral.command.order;

import com.wulibao.provider.design.pattern.behavioral.command.order.service.Order;

import java.util.ArrayList;
import java.util.List;

/**
 * @author WuliBao
 * @date 2020-04-30
 */
public class Broker {
    private final List<Order> orders = new ArrayList<>();
    
    public void addOrder(Order order) {
        orders.add(order);
    }
    
    public void execute() {
        orders.forEach(Order::execute);
    }
}
