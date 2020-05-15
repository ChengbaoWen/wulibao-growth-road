package com.wulibao.provider.design.pattern.behavioral.memento;

import java.util.ArrayList;
import java.util.List;

/**
 * 备忘录仓库
 * 
 * @author WuliBao
 * @date 2020-05-14
 */
public class CareTaker {
    /**
     * User备忘录集合
     */
    private final List<MementoUser> list = new ArrayList<>();
    
    public void add(MementoUser mementoUser) {
        list.add(mementoUser);
    }
    
    public MementoUser get(int i) {
        return list.get(i);
    }
    
    public List<MementoUser> getList() {
        return this.list;
    }
}
