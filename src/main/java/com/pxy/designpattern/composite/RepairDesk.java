package com.pxy.designpattern.composite;

public class RepairDesk extends CalculatorShop {
    public RepairDesk(String name) {
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
        System.out.println(name + ": 修理计算器");
    }
}
