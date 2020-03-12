package com.pxy.designpattern.decorator;


import com.pxy.designpattern.Calculator;

public abstract class ShowColor extends Calculator {
    protected Calculator calculator;
    public void setCalculator(Calculator calculator) {
        this.calculator = calculator;
    }
    @Override
    public int computeByStrategy(int num1, String operator, int num2) throws Exception {
        if (calculator != null) {
            show();
            return calculator.computeByStrategy(num1, operator,num2);
        } else {
            throw new Exception("不能调用空对象的方法！");
        }
    };
    private void show() {
        System.out.print("show ");
    }
    protected abstract void showColor();
}
