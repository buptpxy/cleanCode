package com.pxy.designpattern.command;

public abstract class Command {
    Calculator calculator;
    public Command(Calculator calculator) {
        this.calculator = calculator;
    }
    public abstract void executeCommand();
}
