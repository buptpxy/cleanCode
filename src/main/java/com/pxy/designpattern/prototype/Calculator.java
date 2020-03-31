package com.pxy.designpattern.prototype;

import java.util.Calendar;

public class Calculator implements Cloneable {
    private Brand brand;
    private String type;
    private String color;
    private Calendar productionDate;
    private int price;

    public Calculator() {
        brand = new Brand();
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


    public Brand getBrand() {
        return brand;
    }

    public void setBrandName(String name) {
        brand.setName(name);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
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

    public Calculator deepClone() throws CloneNotSupportedException {
        Calculator calculatorCopy = (Calculator) super.clone();
        calculatorCopy.brand = brand.deepClone();
        return calculatorCopy;
    }
}