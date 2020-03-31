package com.pxy.designpattern.decorator;

public class Calculator{

    protected int compute(int num1, String operator, int num2) throws Exception {
        switch (operator) {
            case "+":
                return num1+num2;
            case "-":
                return num1-num2;
            case "*":
                return num1*num2;
            case "/":
                if (num2 == 0) {
                    throw new Exception("除数不能为0");
                } else {
                    return num1/num2;
                }
            default:
                throw new Exception("运算符输入错误!");
        }
    }
}