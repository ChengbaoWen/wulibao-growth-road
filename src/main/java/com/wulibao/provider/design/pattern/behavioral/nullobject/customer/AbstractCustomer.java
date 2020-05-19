package com.wulibao.provider.design.pattern.behavioral.nullobject.customer;

import lombok.Data;

/**
 * @author WuliBao
 * @date 2020-05-19
 */
@Data
public abstract class AbstractCustomer {
    private String name;
    
    private boolean isNull;
}
