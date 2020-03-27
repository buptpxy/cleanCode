package com.pxy.designpattern.singleton;

public class LazySingleton {
    private static LazySingleton singleton;
    private LazySingleton() {}
    public static LazySingleton getInstance() {
        if (singleton.getInstance() == null) {
            singleton = new LazySingleton();
        }
        return singleton;
    }
}
