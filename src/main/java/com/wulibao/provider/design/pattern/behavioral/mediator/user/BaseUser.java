package com.wulibao.provider.design.pattern.behavioral.mediator.user;

import java.util.ArrayList;
import java.util.List;

import com.wulibao.provider.design.pattern.behavioral.mediator.Mediator;

/**
 * @author WuliBao
 * @date 2020-05-14
 */
public class BaseUser {
    /**
     * 名字
     */
    private final String name;
    
    /**
     * 收到的消息集合
     */
    private final List<String> messages;
    
    protected BaseUser(String name) {
        this.name = name;
        this.messages = new ArrayList<>();
        Mediator.registerUser(this);
    }
    
    public String getName() {
        return this.name;
    }
    
    /**
     * 发送 消息
     * 
     * @param name name
     * @param message message
     */
    public void sendMessage(String name, String message) {
        Mediator.sendMessage(name, message);
    }
    
    /**
     * 接受消息
     * 
     * @param message message
     */
    public void receiveMessage(String message) {
        messages.add(message);
    }
    
    /**
     * 获取消息
     */
    public List<String> getMessages() {
        return this.messages;
    }
}
