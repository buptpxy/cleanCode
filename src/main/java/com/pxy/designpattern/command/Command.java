package com.pxy.designpattern.command;

import com.pxy.designpattern.Calculator;

public abstract class Command {
    Calculator calculator;
    public Command(Calculator calculator) {
        this.calculator = calculator;
    }
    public abstract void executeCommand();
}
