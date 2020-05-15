package com.wulibao.provider.design.pattern.behavioral.iterator;

/**
 * 集合接口
 * 
 * @author WuliBao
 * @date 2020-05-14
 */
public interface Container<T> {
    
    /**
     * 获取迭代器
     * 
     * @return Iterator
     */
    Iterator<T> iterator();
    
    /**
     * 向集合添加元素
     * 
     * @param t t
     */
    void add(T t);
    
    /**
     * 获取集合元素
     * 
     * @param i i
     * @return T
     */
    T get(int i);
    
    /**
     * 获取集合大小
     * 
     * @return int
     */
    int size();
}
