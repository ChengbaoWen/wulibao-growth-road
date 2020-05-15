package com.wulibao.provider.design.pattern.behavioral.iterator;

import java.util.Arrays;

/**
 * @author WuliBao
 * @date 2020-05-14
 */
public class WulisList<T> implements Container<T> {
    /**
     * 对象数组
     */
    private T[] t;
    
    /**
     * 默认的空数组
     */
    private static final Object[] DEFAULT_CAPACITY_EMPTY_ELEMENT_DATA = {};
    
    /**
     * 对象数组的长度
     */
    private int size;
    
    @SuppressWarnings("unchecked")
    public WulisList() {
        // 初始化空数组
        this.t = (T[])DEFAULT_CAPACITY_EMPTY_ELEMENT_DATA;
    }
    
    @Override
    public Iterator<T> iterator() {
        return new Iter();
    }
    
    /**
     * 集合添加元素
     * 
     * @param t t
     */
    @Override
    public void add(T t) {
        // 数组拷贝,使数组扩容+1
        this.t = Arrays.copyOf(this.t, size + 1);
        // 修改数组长度+1
        this.size += 1;
        // 最后的数组空间存放新加入的元素
        this.t[size - 1] = t;
    }
    
    @Override
    public T get(int i) {
        return t[i];
    }
    
    @Override
    public int size() {
        return this.size;
    }
    
    @Override
    public String toString() {
        return "WulisList" + Arrays.toString(t);
    }
    
    /**
     * 迭代器实现
     */
    private class Iter implements Iterator<T> {
        
        /**
         * 当前迭代器索引值
         */
        private int index = 0;
        
        @Override
        public boolean hasNext() {
            return index < t.length;
        }
        
        @Override
        public T next() {
            return t[index++];
        }
    }
}
