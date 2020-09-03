package com.wulibao.provider.stream;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * java8 Stream流式操作
 *
 * flatMap把集合压平
 * 
 * @author WuliBao
 * @date 2020-06-23
 */
public class StreamMain {
    public static void main(String[] args) {
        List<List<String>> list =
            Arrays.asList(Arrays.asList("a", "b", "c"), Arrays.asList("d", "e", "f"), Arrays.asList("g", "h", "i"));
        List<String> collect = list.stream().flatMap(Collection::stream).collect(Collectors.toList());
        System.out.println(collect);
        List<HashMap<String, String>> hashMapList = list.stream().flatMap(l -> l.stream().map(t -> {
            HashMap<String, String> map = new HashMap<>(1);
            map.put(t, t);
            return map;
        })).collect(Collectors.toList());
        System.out.println(hashMapList);
        System.out.println(hashMapList.stream().findFirst().get());
        boolean g = collect.stream().anyMatch(s -> s.equals("g"));
        System.out.println(g);
    }
}
