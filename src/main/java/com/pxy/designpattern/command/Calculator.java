package com.pxy.designpattern.command;

import java.util.Calendar;

public class Calculator implements Cloneable {
    private String type;
    private String color;
    private Calendar productionDate;
    private int price;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Calendar getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(Calendar productionDate) {
        this.productionDate = productionDate;
    }

    public Calculator clone() throws CloneNotSupportedException {
        return (Calculator) super.clone();
    }

    public void packageChip() {
        System.out.println("A chip has packaged!");
    }
    public void packageKeyboard() {
        System.out.println("A keyboard has packaged!");
    }
    public void packageScreen(){
        System.out.println("A screen has packaged!");
    };
    public void packageShell() {
        System.out.println("A red shell has packaged!");
    }

    public int compute(int num1, String operator, int num2) throws Exception {
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