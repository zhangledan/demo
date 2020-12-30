package com.example.demo.thread;

/**
 * @author ledan.zhang
 * @createdAt: 2020-12-25
 */
public class Demo1 extends Demo {
    String name ;
    public Demo1(String name) {
        super(name);
        this.name = name;
        System.out.println("子类构造函数");
    }

    public static void main(String[] args) {
    }
}
