package com.wulibao.provider.design.pattern.behavioral.nullobject.customer;

import org.springframework.lang.NonNull;

/**
 * @author WuliBao
 * @date 2020-05-19
 */
public class RealCustomer extends AbstractCustomer {
    public RealCustomer(@NonNull String name) {
        this.setName(name);
        setNull(false);
    }
}
