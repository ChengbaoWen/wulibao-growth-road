package com.wulibao.provider.design.pattern.behavioral.memento;

/**
 * 备忘录模式
 * 
 * @author WuliBao
 * @date 2020-05-14
 */
public class MementoPatternMain {
    public static void main(String[] args) {
        // 初始化存档对象
        CareTaker careTaker = new CareTaker();
        // 创建小明对象，18岁
        User user = User.builder().name("小明").age(18).build();
        // 存档
        careTaker.add(OriginatorUser.saveStateToMemento(user));
        // 读档
        user = OriginatorUser.getStateFromMemento(careTaker.get(0));
        System.out.println("User 信息：" + user.toString());
        System.out.println("存档对象信息：" + careTaker.getList().toString());
        // 修改小明的年龄为19岁
        user.setAge(19);
        // 存档
        careTaker.add(OriginatorUser.saveStateToMemento(user));
        // 读档
        user = OriginatorUser.getStateFromMemento(careTaker.get(1));
        System.out.println("User 信息：" + user.toString());
        System.out.println("存档对象信息：" + careTaker.getList().toString());
    }
}
