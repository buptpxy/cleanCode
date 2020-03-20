package com.pxy.designpattern.bridge;

public abstract class Shell {
    protected Color color;

    public void setColor(Color color) {
        this.color = color;
    }
    public abstract void make();
}
