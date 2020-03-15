package com.pxy.designpattern.builder;

import com.pxy.designpattern.Calculator;

public abstract class CalculatorBuilder {
    public abstract void buildChip();
    public abstract void buildScreen();
    public abstract void buildKeyboard();
    public abstract void buildShell();
    public abstract Calculator packageCalculator();
}
