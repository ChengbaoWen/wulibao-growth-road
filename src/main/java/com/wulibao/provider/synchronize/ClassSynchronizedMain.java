package com.wulibao.provider.synchronize;

/**
 * 方法代码块加锁测试（类同步）
 * 
 * 不同实例执行方法，测试类加锁的代码块是否会序列化执行
 * 
 * @author WuliBao
 * @date 2020-06-03
 */
public class ClassSynchronizedMain {
    public static void main(String[] args) {
        // 第一种：同一实例，执行同步代码块
        // one();
        // 第二种：不同实例，执行同步代码块
        two();
    }
    
    /**
     * 第一种：同一实例，执行同步代码块
     * 
     * 结论：会 序列化执行
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
     * 第二种：不同实例，执行同步代码块
     * 
     * 结论：会 序列化执行
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
        void play(String words) {
            synchronized (Horn.class) {
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
