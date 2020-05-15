package com.wulibao.provider.design.pattern.behavioral.memento;

import com.wulibao.provider.design.pattern.creational.prototype.util.CopyUtil;

/**
 * 备忘录发起者
 * 
 * @author WuliBao
 * @date 2020-05-14
 */
public class OriginatorUser {
    
    public static MementoUser saveStateToMemento(User user) {
        return new MementoUser(user);
    }
    
    public static User getStateFromMemento(MementoUser mementoUser) {
        return CopyUtil.deep(mementoUser.getUser());
    }
    
}
