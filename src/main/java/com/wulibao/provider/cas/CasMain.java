package com.wulibao.provider.cas;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 多线程修改同一变量测试
 * 
 * @author WuliBao
 * @date 2020-06-02
 */
public class CasMain {
    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("a", "b", "c", "d");
        AtomicInteger i = new AtomicInteger();
        stringList.forEach(s -> {
            i.getAndIncrement();
            System.out.println(i.get());
        });
    }
}
