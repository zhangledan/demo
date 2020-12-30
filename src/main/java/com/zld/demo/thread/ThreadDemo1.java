package com.example.demo.thread;

import java.util.concurrent.TimeUnit;

/**
 * @author ledan.zhang
 * @createdAt: 2020-12-23
 */
public class ThreadDemo1 {
    public static void main(String[] args) throws Exception {

        Thread thread1 = new Thread(ThreadDemo1::pint, "thread1  1");
        Thread thread2 = new Thread(() -> {
            ThreadDemo1.pint();
            try {
                thread1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "thread2  2");
        thread1.start();
        thread2.start();
        thread1.join();
        System.out.println(Thread.currentThread().getName());
    }

    public static void pint() {
        for (int i = 0; i < 10; i++) {
            try {
                TimeUnit.MILLISECONDS.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }

}