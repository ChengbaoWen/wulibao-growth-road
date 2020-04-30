package com.wulibao.provider.test.design.pattern.structural.filter.filter.service;

import com.wulibao.provider.test.design.pattern.structural.filter.filter.Person;

/**
 * @author WuliBao
 * @date 2020-04-28
 */
public interface Criteria {
    /**
     * 过滤
     * 
     * @param person person
     * @return boolean
     */
    boolean filter(Person person);
}
