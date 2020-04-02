package com.pxy.designpattern.observer;

public class Calculator {
    private int price;
    public Calculator(int price) {
        this.price = price;
    }
    public int getPrice() {
        return price;
    }
}