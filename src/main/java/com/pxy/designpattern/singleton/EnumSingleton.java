package com.pxy.designpattern.singleton;

/**
 * 枚举类实质上是功能齐全的类，因此可有自己的属性和方法，枚举是通过公有的静态final域为每个枚举常量导出实例的类。简洁高效安全，由虚拟机保障不会被实例化多次
 */
public enum EnumSingleton {
    enumSingleton;
}
