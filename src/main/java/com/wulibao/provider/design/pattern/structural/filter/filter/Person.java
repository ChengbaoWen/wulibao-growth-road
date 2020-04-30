package com.wulibao.provider.design.pattern.structural.filter.filter;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author WuliBao
 * @date 2020-04-28
 */
@Data
@Accessors(chain = true)
public class Person {
    
    private String name;
    
    private Integer age;
    
    private String sex;
    
    public Person() {
        
    }
    
    public Person(String name, Integer age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }
}
