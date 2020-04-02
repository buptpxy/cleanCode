package com.pxy.designpattern.flyweight;

public class Client {
    /**
     * 使用享元模式实例化计算器对象
     */
    public static void computeByFlyweight() {
        Flyweight calculator1 = CalculatorFactory.getInstance("+");//3
        System.out.println(calculator1.operate(new ExternalNums(1,2)));
        Flyweight calculator2 = CalculatorFactory.getInstance("+");
        System.out.println(calculator2.operate(new ExternalNums(2,3))); //5
        Flyweight calculator3 = new UnSharedCalculator();
        System.out.println(calculator3.operate(new ExternalNums(3,2))); //0
        System.out.println("CalculatorFactory中的实例个数为：" + CalculatorFactory.instanceCount()); //1
    }

    public static void main(String[] args) {
        computeByFlyweight();
    }
}
