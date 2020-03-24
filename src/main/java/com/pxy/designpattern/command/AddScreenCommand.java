package com.pxy.designpattern.command;

import com.pxy.designpattern.Calculator;

public class AddScreenCommand extends Command {
    public AddScreenCommand(Calculator calculator) {
        super(calculator);
    }

    @Override
    public void executeCommand() {
        calculator.packageScreen();
    }
}
