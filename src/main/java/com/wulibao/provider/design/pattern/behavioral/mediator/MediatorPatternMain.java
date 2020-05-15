package com.wulibao.provider.design.pattern.behavioral.mediator;

import com.wulibao.provider.design.pattern.behavioral.mediator.user.GangUser;
import com.wulibao.provider.design.pattern.behavioral.mediator.user.HongUser;
import com.wulibao.provider.design.pattern.behavioral.mediator.user.MingUser;

/**
 * 中介者模式
 * 
 * @author WuliBao
 * @date 2020-05-14
 */
public class MediatorPatternMain {
    public static void main(String[] args) {
        GangUser gangUser = new GangUser();
        MingUser mingUser = new MingUser();
        gangUser.sendMessage("小明", "小明在吗？");
        System.out.println("小明收到的消息:" + mingUser.getMessages());
        mingUser.sendMessage("小红", "小红在么");
        HongUser hongUser = new HongUser();
        hongUser.sendMessage("小刚", "小刚在吗？");
        System.out.println("小刚收到的消息:" + gangUser.getMessages());
    }
}
