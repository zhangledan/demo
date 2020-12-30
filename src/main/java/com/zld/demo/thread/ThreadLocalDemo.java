package com.example.demo.thread;

import java.util.concurrent.CountDownLatch;

/**
 * @author ledan.zhang
 * @createdAt: 2020-12-24
 */
public class ThreadLocalDemo {
    public static void main(String[] args) throws InterruptedException {
        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        CountDownLatch countDownLatch = new CountDownLatch(2);
        new Thread(()->{
           threadLocal.set("abc");
            System.out.println(Thread.currentThread().getName()+threadLocal.get());
           countDownLatch.countDown();
        },"thread1").start();
        new Thread(()->{
            threadLocal.set("efg");
            System.out.println(Thread.currentThread().getName()+threadLocal.get());
            countDownLatch.countDown();
        },"thread2").start();
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName()+threadLocal.get());
    }
}
