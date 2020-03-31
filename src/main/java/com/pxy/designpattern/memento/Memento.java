package com.pxy.designpattern.memento;

public class Memento {
    private State state;
    private int price;

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Memento(State state, int price) {
        this.state = state;
        this.price = price;
    }

}
