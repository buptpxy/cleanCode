package com.pxy.designpattern.decorator;

public class ShowRed extends ShowColor {
    @Override
    public int computeByStrategy(int num1, String operator, int num2) throws Exception {
        if (computer != null) {
            showRed();
            return computer.computeByStrategy(num1, operator,num2);
        } else {
            throw new Exception("不能调用空对象的方法！");
        }
    };
    private void showRed() {
        System.out.println("show red!");
        System.out.println("hahaha!");
    }
}
