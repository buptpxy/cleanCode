package com.pxy.designpattern.command;

public class AddScreenCommand extends Command {
    public AddScreenCommand(Calculator calculator) {
        super(calculator);
    }

    @Override
    public void executeCommand() {
        calculator.packageScreen();
    }
}
