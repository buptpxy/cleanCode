package com.pxy.designpattern.abstractfactory;

public abstract class ShowColor extends Calculator {
    protected Calculator calculator;
    public void setCalculator(Calculator calculator) {
        this.calculator = calculator;
    }
    @Override
    public int compute(int num1, String operator, int num2) throws Exception {
        if (calculator != null) {
            return calculator.compute(num1, operator,num2);
        } else {
            throw new Exception("不能调用空对象的方法！");
        }
    };
    protected abstract void showColor();
}
