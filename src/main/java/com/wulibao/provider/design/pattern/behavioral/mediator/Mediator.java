package com.wulibao.provider.design.pattern.behavioral.mediator;

import com.wulibao.provider.design.pattern.behavioral.mediator.user.BaseUser;

import java.util.HashMap;

/**
 * @author WuliBao
 * @date 2020-05-14
 */
public class Mediator {
    private static HashMap<String, BaseUser> map;
    
    /**
     * 注册用户
     * 
     * @param user user
     */
    public static void registerUser(BaseUser user) {
        if (map == null) {
            map = new HashMap<>(2);
        }
        map.put(user.getName(), user);
    }
    
    /**
     * 发送消息
     * 
     * @param name name
     * @param message message
     */
    public static void sendMessage(String name, String message) {
        BaseUser user = map.get(name);
        if (user == null) {
            System.out.println(name + "不在线");
        }
        else {
            user.receiveMessage(message);
        }
    }
}
