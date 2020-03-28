package com.pxy.designpattern.visitor;

public abstract class Customer {
    protected String name;
    protected double price;
    public Customer(String name,double price) {
        this.name = name;
        this.price = price;
    }
    public abstract void accept(Action action);
}
