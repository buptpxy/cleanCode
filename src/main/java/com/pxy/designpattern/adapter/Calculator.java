package com.pxy.designpattern.adapter;

import java.util.Calendar;

public class Calculator implements Cloneable {
    private Calendar productionDate;
    private int price;
    private State state;

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

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}