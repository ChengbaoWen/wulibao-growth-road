package com.wulibao.provider.intset;

import java.util.HashSet;
import java.util.Set;

/**
 * 测试Integer 在Set集合中的取值
 * 
 * @author WuliBao
 * @date 2020-09-01
 */
public class SetMain {
    public static void main(String[] args) {
        Integer one = new Integer("128");
        Integer two = new Integer("128");
        System.out.println("one 和 two 是否相等：" + (one == two));
        Set<Integer> set = new HashSet<>(2);
        set.add(one);
        System.out.println("用two 取set中的128值结果：" + set.contains(two));
    }
}
