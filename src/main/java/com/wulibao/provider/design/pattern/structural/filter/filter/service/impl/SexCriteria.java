package com.wulibao.provider.design.pattern.structural.filter.filter.service.impl;

import org.springframework.lang.NonNull;

import com.wulibao.provider.design.pattern.structural.filter.filter.Person;
import com.wulibao.provider.design.pattern.structural.filter.filter.service.Criteria;

/**
 * @author WuliBao
 * @date 2020-04-28
 */
public class SexCriteria implements Criteria {
    
    private final String condition;
    
    public SexCriteria(@NonNull String condition) {
        this.condition = condition;
    }
    
    @Override
    public boolean filter(@NonNull Person person) {
        return condition.equals(person.getSex());
    }
}
