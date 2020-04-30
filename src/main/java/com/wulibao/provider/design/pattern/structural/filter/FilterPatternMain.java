package com.wulibao.provider.test.design.pattern.structural.filter;

import java.util.ArrayList;
import java.util.List;

import com.wulibao.provider.test.design.pattern.structural.filter.filter.PersonFilter;
import com.wulibao.provider.test.design.pattern.structural.filter.filter.service.impl.AgeCriteria;
import com.wulibao.provider.test.design.pattern.structural.filter.filter.service.impl.SexCriteria;
import com.wulibao.provider.test.design.pattern.structural.filter.filter.Person;

/**
 * 过滤模式
 * 
 * @author WuliBao
 * @date 2020-04-28
 */
public class FilterPatternMain {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("小明", 18, "男"));
        persons.add(new Person("小刚", 17, "男"));
        persons.add(new Person("小红", 16, "女"));
        persons.add(new Person("小丽", 18, "女"));
        PersonFilter personFilter = new PersonFilter();
        personFilter
            // 18岁
            .and(new AgeCriteria(18))
            // 性别男
            .and(new SexCriteria("男"));
        List<Person> filter = personFilter.filter(persons);
        System.out.println(filter);
    }
}
