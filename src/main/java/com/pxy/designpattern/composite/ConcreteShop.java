package com.pxy.designpattern.composite;

import java.util.ArrayList;
import java.util.List;

public class ConcreteShop extends CalculatorShop {
    List<CalculatorShop> children = new ArrayList<>();
    public ConcreteShop(String name) {
        super(name);
    }

    @Override
    public void addChildren(CalculatorShop calculatorShop) {
        children.add(calculatorShop);
    }

    @Override
    public void removeChildren(CalculatorShop calculatorShop) {
        children.remove(calculatorShop);
    }

    @Override
    public void display(int depth) {
        System.out.println("-".repeat(depth)+name);
        for (CalculatorShop calculatorShop:children) {
            calculatorShop.display(depth+2);
        }
    }

    @Override
    public void doBusiness() {
        for (CalculatorShop calculatorShop:children) {
            calculatorShop.doBusiness();
        }
    }
}
