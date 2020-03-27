package com.pxy.designpattern.singleton;

import java.util.Iterator;

public class DoubleCheckSingleton {
    private volatile static DoubleCheckSingleton singleton;//要加volatile，保证线程间的可见性
    private DoubleCheckSingleton() {}
    public static DoubleCheckSingleton getInstance() {
        if (singleton.getInstance() == null) {//不让线程每次访问getInstance方法都加锁，只有在没有实例化时才加锁
            synchronized (DoubleCheckSingleton.class) { //锁的是类对象，不是实例对象singleton，因为singleton不一定被创建出来了
                if (singleton.getInstance() == null) { //如果有多个线程同时通过了第一层校验，在获得锁后如果不再校验一次，有可能实例已经被创建过了
                    singleton = new DoubleCheckSingleton();
                }
            }
        }
        return singleton;
    }
}
