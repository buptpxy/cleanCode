package com.pxy.designpattern.adapter;

public abstract class State {
    public abstract void setPrice(Calculator calculator,int basePrice);
    protected abstract void changeState(Calculator calculator,int basePrice);
}
