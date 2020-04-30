package com.wulibao.provider.test.design.pattern.structural.filter.filter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

import com.wulibao.provider.test.design.pattern.structural.filter.filter.service.Criteria;

/**
 * @author WuliBao
 * @date 2020-04-28
 */
public class PersonFilter {
    
    private final List<Criteria> ands = new ArrayList<>();
    
    public PersonFilter and(Criteria filter) {
        ands.add(filter);
        return this;
    }
    
    public List<Person> filter(List<Person> persons) {
        List<Person> andList = new ArrayList<>();
        AtomicBoolean andFlag = new AtomicBoolean(true);
        persons.forEach(person -> {
            for (Criteria criteria : ands) {
                boolean f = criteria.filter(person);
                if (!f) {
                    andFlag.set(false);
                    break;
                }
            }
            if (andFlag.get()) {
                andList.add(person);
            }
        });
        return andList;
    }
    
}
