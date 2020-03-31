package com.pxy.designpattern.abstractfactory;

public abstract class ShowColor extends Calculator {
    protected Calculator calculator;
    public void setCalculator(Calculator calculator) {
        this.calculator = calculator;
    }
    @Override
    public int compute(int num1, String operator, int num2) throws Exception {
        if (calculator != null) {
            show();
            return calculator.compute(num1, operator,num2);
        } else {
            throw new Exception("不能调用空对象的方法！");
        }
    };
    private void show() {
        System.out.print("show ");
    }
    protected abstract void showColor();
}
