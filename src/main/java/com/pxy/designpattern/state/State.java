package com.pxy.designpattern.state;

public abstract class State {
    public abstract void setPrice(Calculator calculator,int basePrice);
    protected abstract void changeState(Calculator calculator,int basePrice);
}
