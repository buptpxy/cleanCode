package com.pxy.designpattern.flyweight;

public abstract class Flyweight {
    //Flyweight使共享成为可能，但不强制共享，因此可有不共享内部状态的子类
    //外部状态通过要使用的实例方法设置
    public abstract int operate(ExternalNums externalNums);
}
