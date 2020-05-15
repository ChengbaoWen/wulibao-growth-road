package com.wulibao.provider.design.pattern.behavioral.iterator;

/**
 * @author WuliBao
 * @date 2020-05-14
 */
public interface Iterator<T> {
    /**
     * 判断迭代器是否有下一个节点
     * 
     * @return boolean
     */
    boolean hasNext();
    
    /**
     * 获取下一个节点
     * 
     * @return T
     */
    T next();
}
