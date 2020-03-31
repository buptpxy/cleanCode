package com.pxy.designpattern.state;

import java.util.Calendar;

public class Calculator implements Cloneable {
    private String type;
    private String color;
    private Calendar productionDate;
    private int price;
    private State state;
    private ProductState productState;

    public Calculator() {
        state = new NewProductState();
    }

    public int getPrice() {
        return price;
    }
    public void setPrice(int basePrice) {
        state.setPrice(this, basePrice);
    }

    public Calendar getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(Calendar productionDate) {
        this.productionDate = productionDate;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
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

    public void setProductState(ProductState productState) {
        this.productState = productState;
    }

    public ProductState getProductState() {
        return this.productState;
    }
}