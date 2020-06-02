package com.wulibao.provider.inter;

/**
 * 接口继承问题
 * 
 * @author WuliBao
 * @date 2020-05-29
 */
public class InterfaceMain {
    public static void main(String[] args) {
        // 领养一个哈士奇
        Dog husky = new Husky();
        husky.name();
        husky.shout();
    }
}

/**
 * 动物接口
 */
interface Animal {
    /**
     * 名称
     */
    void name();
}

/**
 * 狗
 */
interface Dog extends Animal {
    /**
     * 叫
     */
    void shout();
}

/**
 * 哈士奇（狗）
 */
class Husky implements Dog {
    
    @Override
    public void name() {
        System.out.println("二哈");
    }
    
    @Override
    public void shout() {
        System.out.println("啊呕~~~~~");
    }
}
