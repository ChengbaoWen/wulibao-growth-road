package com.wulibao.provider.test.design.pattern.structural.filter.filter.service.impl;

import org.springframework.lang.NonNull;

import com.wulibao.provider.test.design.pattern.structural.filter.filter.Person;
import com.wulibao.provider.test.design.pattern.structural.filter.filter.service.Criteria;

/**
 * @author WuliBao
 * @date 2020-04-28
 */
public class AgeCriteria implements Criteria {
    
    private final Integer condition;
    
    public AgeCriteria(@NonNull Integer condition) {
        this.condition = condition;
    }
    
    @Override
    public boolean filter(@NonNull Person person) {
        return condition.equals(person.getAge());
    }
}
