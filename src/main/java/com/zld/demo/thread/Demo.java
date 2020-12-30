package com.example.demo.thread;

/**
 * @author ledan.zhang
 * @createdAt: 2020-12-25
 */
public class Demo implements Cloneable{
    String name ;
    Demo1 demo1;
    static {
        System.out.println("aaaaaaaaa");
    }

    public Demo(String name) {
        this.name = name;
        System.out.println("父类构造函数");
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Demo zld = new Demo("zld");
        Demo1 demo1 = new Demo1("xly");
        zld.demo1 = demo1;
        Demo clone = zld.clone();
        System.out.println(clone.name);
        System.out.println(clone.demo1.name);

    }
    @Override
    protected  Demo clone() throws CloneNotSupportedException {
        Demo clone = (Demo)super.clone();
        return clone;
    }
}
