package com.pxy.designpattern.state;

public abstract class State {
    State nextState;
    public void setNextState(State nextState) {
        this.nextState = nextState;
    }
    public abstract void setPrice(Calculator calculator,int basePrice);
    protected abstract void changeState(Calculator calculator);
}
