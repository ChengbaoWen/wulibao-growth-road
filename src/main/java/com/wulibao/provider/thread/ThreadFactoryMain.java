package com.wulibao.provider.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

/**
 * @author WuliBao
 * @date 2020-05-20
 */
public class ThreadFactoryMain {
    public static void main(String[] args) {
        List<Future<String>> list = new ArrayList<>();
        // 使用线程池，核心线程为3个
        ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("thread-pool-%d").build();
        ExecutorService threadPool = new ThreadPoolExecutor(3, 3, 0L, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<>(10240), threadFactory, new ThreadPoolExecutor.AbortPolicy());
        // 异步执行任务A
        list.add(threadPool.submit(() -> {
            System.out.println("wulibao");
            return "wulibao";
        }));
        // 异步执行任务B
        list.add(threadPool.submit(() -> {
            System.out.println("wulilun");
            // 休眠3s测试等待线程结束
            Thread.sleep(3000);
            return "wulilun";
        }));
        threadPool.shutdown();
        // 获取线程返回值
        for (Future<String> s : list) {
            try {
                System.out.println("打印结果：" + s.get());
            }
            catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        System.out.println("阻塞结束");
    }
}
