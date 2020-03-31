package com.pxy.designpattern.command;

public class AddShellCommand extends Command {
    public AddShellCommand(Calculator calculator) {
        super(calculator);
    }

    @Override
    public void executeCommand() {
        calculator.packageShell();
    }
}
