package com.pxy.designpattern.flyweight;

public class SharedCalculator extends Flyweight {
    private String operation;
    //内部状态通过构造函数设置
    public SharedCalculator(String operation) {
        this.operation = operation;
    }
    @Override
    public int operate(ExternalNums externalNums) { //外部状态通过实例方法的参数传入，只改变方法行为，不改变对象本身
        switch (operation) {
            case "+":
                return externalNums.getNum1() + externalNums.getNum2();
            case "-":
                return externalNums.getNum1() - externalNums.getNum2();
            case "*":
                return externalNums.getNum1() * externalNums.getNum2();
            case "/":
                if (externalNums.getNum2() == 0) {
                    return 0;
                }
                return externalNums.getNum1() / externalNums.getNum2();
            default:
                return 0;
        }
    }
}
