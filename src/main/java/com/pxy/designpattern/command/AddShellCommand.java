package com.pxy.designpattern.command;

import com.pxy.designpattern.Calculator;

public class AddShellCommand extends Command {
    public AddShellCommand(Calculator calculator) {
        super(calculator);
    }

    @Override
    public void executeCommand() {
        calculator.packageShell();
    }
}
