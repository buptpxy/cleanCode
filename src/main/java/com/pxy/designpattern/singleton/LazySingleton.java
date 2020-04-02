package com.pxy.designpattern.singleton;

public class LazySingleton {
    private static LazySingleton singleton = null;
    private LazySingleton() {}
    public static LazySingleton getInstance() {
        if (singleton == null) {
            singleton = new LazySingleton();
        }
        return singleton;
    }
}
