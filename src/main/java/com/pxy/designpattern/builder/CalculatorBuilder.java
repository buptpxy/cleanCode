package com.pxy.designpattern.builder;

public abstract class CalculatorBuilder {
    public abstract void buildChip();
    public abstract void buildScreen();
    public abstract void buildKeyboard();
    public abstract void buildShell();
    public abstract Calculator packageCalculator();
}
