package com.wulibao.provider.design.pattern.behavioral.nullobject;

import com.wulibao.provider.design.pattern.behavioral.nullobject.customer.AbstractCustomer;
import com.wulibao.provider.design.pattern.behavioral.nullobject.customer.CustomerFactory;

/**
 * 空对象模式
 * 
 * @author WuliBao
 * @date 2020-05-19
 */
public class NullObjectPatternMain {
    public static void main(String[] args) {
        AbstractCustomer ming = CustomerFactory.getCustomer("小明");
        AbstractCustomer gang = CustomerFactory.getCustomer("小刚");
        AbstractCustomer customer = CustomerFactory.getCustomer(null);
        System.out.println(ming.getName() + ":" + ming.isNull());
        System.out.println(gang.getName() + ":" + gang.isNull());
        System.out.println(customer.getName() + ":" + customer.isNull());
    }
}
