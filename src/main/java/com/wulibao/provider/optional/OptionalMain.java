package com.wulibao.provider.optional;

import java.util.Optional;

/**
 * Optional测试
 * 
 * @author WuliBao
 * @date 2020-06-11
 */
public class OptionalMain {
    public static void main(String[] args) {
        Integer integer = 1;
        Optional<Integer> optional = Optional.of(integer);
        System.out.println(optional);
        Optional<Integer> nullOptional = Optional.of(null);
        System.out.println(nullOptional);
    }
}
