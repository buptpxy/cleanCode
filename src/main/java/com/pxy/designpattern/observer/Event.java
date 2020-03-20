package com.pxy.designpattern.observer;
@FunctionalInterface
public interface Event {
    void Notify(int price);
}
