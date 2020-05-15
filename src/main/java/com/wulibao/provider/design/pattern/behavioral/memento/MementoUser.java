package com.wulibao.provider.design.pattern.behavioral.memento;

import java.time.LocalDateTime;

import com.wulibao.provider.design.pattern.creational.prototype.util.CopyUtil;

import lombok.Data;

/**
 * User的备忘录
 * 
 * @author WuliBao
 * @date 2020-05-14
 */
@Data
public class MementoUser {
    private final User user;
    
    private final LocalDateTime localDateTime;
    
    public MementoUser(User user) {
        this.user = CopyUtil.deep(user);
        this.localDateTime = LocalDateTime.now();
    }
}
