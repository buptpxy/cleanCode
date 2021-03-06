package com.pxy.designpattern.responsibility;

public abstract class State {
    State nextState;
    public void setNextState(State nextState) {
        this.nextState = nextState;
    }
    public abstract void setPrice(Calculator calculator, int basePrice);
}
