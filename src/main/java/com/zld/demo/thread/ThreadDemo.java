package com.example.demo.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author ledan.zhang
 * @createdAt: 2020-12-23
 */
public class ThreadDemo {
    static Object object = new Object();
    public static void main(String[] args) throws InterruptedException {
        List<String> waitList = new ArrayList();
        List<String> notifyList = new ArrayList();
        for (int i = 0; i < 50; i++) {
            new Thread(()->{
                synchronized (object){
                    waitList.add(Thread.currentThread().getName());
                    try {
                        object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                notifyList.add(Thread.currentThread().getName());
            }).start();
            for (int j = 0; j < 50 ; j++) {
                synchronized (object){
                    object.notify();
                }
            }
            TimeUnit.SECONDS.sleep(1);
            System.out.println("wait顺序:"+waitList.toString());
            System.out.println("唤醒顺序:"+notifyList.toString());
        }
    }
}
