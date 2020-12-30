package com.example.demo.thread;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author ledan.zhang
 * @createdAt: 2020-12-24
 */
public class CycleBarrierTest2 {
    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(2);
    static int a ;
    public static void main(String[] args) {
        int b;
        System.out.println(a);
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        // 将线程A添加到线程池
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("线程A：" + Thread.currentThread().getName() + "执行第1步。");
                    cyclicBarrier.await();
                    System.out.println("线程A：" + Thread.currentThread().getName() + "执行第2步。");
                    cyclicBarrier.await();
                    System.out.println("线程A：" + Thread.currentThread().getName() + "执行第3步。");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        // 将线程B添加到线程池
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("线程B：" + Thread.currentThread().getName() + "执行第1步。");
                    Thread.sleep(5000L);
                    cyclicBarrier.await();
                    System.out.println("线程B：" + Thread.currentThread().getName() + "执行第2步。");
                    Thread.sleep(5000L);
                    cyclicBarrier.await();
                    System.out.println("线程B：" + Thread.currentThread().getName() + "执行第3步。");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        // 关闭线程池
        executorService.shutdown();
    }
}
