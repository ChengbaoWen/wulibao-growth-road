package com.wulibao.provider.design.pattern.behavioral.nullobject.customer;

/**
 * @author WuliBao
 * @date 2020-05-19
 */
public class CustomerFactory {
    
    public static AbstractCustomer getCustomer(String name) {
        if (name != null) {
            return new RealCustomer(name);
        }
        return new NullCustomer();
    }
}
