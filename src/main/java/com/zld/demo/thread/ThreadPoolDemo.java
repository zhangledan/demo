package com.example.demo.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author ledan.zhang
 * @createdAt: 2020-12-24
 */
public class ThreadPoolDemo {
    static ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 3, 60L, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(10), new ThreadPoolExecutor.AbortPolicy());

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(2);
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName());
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }
            }).start();
            System.out.println("当前活跃线程" + Thread.activeCount());
        }
    }
}
