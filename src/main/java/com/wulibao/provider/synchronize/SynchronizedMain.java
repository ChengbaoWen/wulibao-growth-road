package com.wulibao.provider.synchronize;

/**
 * 局部变量加锁测试
 * 
 * 局部变量作为参数传入方法，检测同步代码块是否会锁住局部变量，即是否方法会序列化执行
 * 
 * @author WuliBao
 * @date 2020-06-03
 */
public class SynchronizedMain {
    public static void main(String[] args) {
        // 第一种：同一实例，传入的局部变量相等（object1 = object2）
        // one();
        // 第二种：同一实例，传入的局部变量不相等（object3 != object4）
        // two();
        // 第三种，不同实例，传入地址相等的局部变量（object5 == object6）
        three();
    }
    
    /**
     * 第一种：同一实例，传入的局部变量相等（object1 = object2）
     * 
     * 结论：同步代码块 会 序列化执行
     * 
     * 因为传入play()方法中的words1和words2的关系为：words1 = words2(即完全相等)
     * 
     * 所以play()的同步锁锁住的对象 是 同一个
     */
    static void one() {
        Horn horn = new Horn();
        String words1 = "哈哈";
        String words2 = "哈哈";
        System.out.println("传入的局部变量相等（object1 == object2）" + (words1 == words2));
        Thread one = new Thread(() -> horn.play(words1));
        Thread two = new Thread(() -> horn.play(words2));
        one.start();
        two.start();
    }
    
    /**
     * 第二种：同一实例，传入的局部变量不相等（object3 != object4）
     *
     * 结论：同步代码块 不会 序列化执行
     *
     * 因为传入play()方法中的words3和words4的关系为：words3 != words4(虽然值相等即 equals 相等)
     *
     * 所以play()的同步锁锁住的对象 不是 同一个
     */
    static void two() {
        Horn horn = new Horn();
        String words3 = "呵呵";
        String words4 = new String("呵呵");
        System.out.println("传入的局部变量不相等（object3 != object4）" + (words3 == words4));
        Thread three = new Thread(() -> horn.play(words3));
        Thread four = new Thread(() -> horn.play(words4));
        three.start();
        four.start();
    }
    
    /**
     * 第三种，不同实例，传入地址相等的局部变量（object5 == object6）
     *
     * 结论：同步代码块 会 序列化执行
     *
     * 因为传入play()方法中的words5和words6的关系为：words5 == words6 虽然不同实例，但是对象的锁是一个
     *
     * 所以play()的同步锁锁住的对象 是 同一个
     */
    static void three() {
        String words5 = "嘿嘿";
        String words6 = "嘿嘿";
        System.out.println("传入的局部变量相等（object5 == object6）" + (words5 == words6));
        Horn hornFive = new Horn();
        Horn hornSix = new Horn();
        Thread five = new Thread(() -> hornFive.play(words5));
        Thread six = new Thread(() -> hornSix.play(words6));
        five.start();
        six.start();
    }
    
    static class Horn {
        void play(String words) {
            synchronized (words) {
                System.out.println("正在播放：" + words);
                try {
                    Thread.sleep(5000);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
