package com.wulibao.provider.design.pattern.behavioral.iterator;

/**
 * 迭代器模式
 * 
 * @author WuliBao
 * @date 2020-05-14
 */
public class IteratorPatternMain {
    
    public static void main(String[] args) {
        Container<String> list = new WulisList<>();
        list.add("小明");
        list.add("小赵");
        list.add("小张");
        System.out.println("WuliBao container:" + list.toString());
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            System.out.println("迭代器遍历元素:" + next);
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println("for循环遍历元素:" + list.get(i));
        }
    }
}
