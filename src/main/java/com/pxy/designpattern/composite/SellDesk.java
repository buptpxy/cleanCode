package com.pxy.designpattern.composite;

public class SellDesk extends CalculatorShop {
    public SellDesk(String name) {
        super(name);
    }

    @Override
    public void addChildren(CalculatorShop calculatorShop) {

    }

    @Override
    public void removeChildren(CalculatorShop calculatorShop) {

    }

    @Override
    public void display(int depth) {
        System.out.println("-".repeat(depth)+name);
    }

    @Override
    public void doBusiness() {
        System.out.println(name + ": 卖计算器");
    }
}
