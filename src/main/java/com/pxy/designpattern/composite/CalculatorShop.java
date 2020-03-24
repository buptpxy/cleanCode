package com.pxy.designpattern.composite;

public abstract class CalculatorShop {
    protected String name;
    public CalculatorShop(String name) {this.name = name;}
    public abstract void addChildren(CalculatorShop calculatorShop);
    public abstract void removeChildren(CalculatorShop calculatorShop);
    public abstract void display(int depth);
    public abstract void doBusiness();
}
