package com.wulibao.provider.design.pattern.behavioral.nullobject.customer;

/**
 * @author WuliBao
 * @date 2020-05-19
 */
public class NullCustomer extends AbstractCustomer {
    public NullCustomer() {
        setNull(true);
    }
    
    @Override
    public String getName() {
        return "Null Customer";
    }
}
