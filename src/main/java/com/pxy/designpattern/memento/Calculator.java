package com.pxy.designpattern.memento;

import java.util.Date;

public class Calculator implements Cloneable {
    private Date productionDate;
    private int price;
    private State state;

    public Calculator() {
        this.state = new NewProductState();
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setPriceByState(int basePrice) {
        state.setPrice(this, basePrice);
    }

    public Date getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(Date productionDate) {
        this.productionDate = productionDate;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Memento backup() {
        return new Memento(state, price);
    }

    public void recover(Memento memento) {
        state = memento.getState();
        price = memento.getPrice();
    }
}