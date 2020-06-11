package com.wulibao.provider.synchronize;

/**
 * 方法加锁测试
 * 
 * 不同实例执行加锁的方法，测试方法是否会序列化执行（实例方法，非静态方法）
 * 
 * @author WuliBao
 * @date 2020-06-03
 */
public class MethodSynchronizedMain {
    public static void main(String[] args) {
        // 第一种：同一实例，执行同步方法
        // one();
        // 第二种：不同实例，执行同步方法
        two();
    }
    
    /**
     * 第一种：同一实例，执行同步方法
     * 
     * 结论：同步方法为实例方法，会 序列化执行
     */
    static void one() {
        Horn horn = new Horn();
        String words = "哈哈";
        Thread one = new Thread(() -> horn.play(words));
        Thread two = new Thread(() -> horn.play(words));
        one.start();
        two.start();
    }
    
    /**
     * 第二种：不同实例，执行同步方法
     * 
     * 结论：同步方法为实例方法，不会 序列化执行
     */
    static void two() {
        Horn hornOne = new Horn();
        Horn hornTwo = new Horn();
        String words = "哈哈";
        Thread one = new Thread(() -> hornOne.play(words));
        Thread two = new Thread(() -> hornTwo.play(words));
        one.start();
        two.start();
    }
    
    static class Horn {
        synchronized void play(String words) {
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
