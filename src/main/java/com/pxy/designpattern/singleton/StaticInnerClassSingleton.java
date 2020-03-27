package com.pxy.designpattern.singleton;

public class StaticInnerClassSingleton {
    private StaticInnerClassSingleton() {}

    /**
     * 静态内部类只有在被调用时才会被加载，加载时会初始化这个内部类的静态变量，由虚拟机保证只会被初始化一次，这样就同时实现了延迟加载和线程安全
     */
    private static class Singleton {
       public static StaticInnerClassSingleton singleton = new StaticInnerClassSingleton();
    }
    public static StaticInnerClassSingleton getInstance() {
        return Singleton.singleton;
    }
}
