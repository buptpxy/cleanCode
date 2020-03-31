package com.pxy.designpattern.command;

public class AddKeyboardCommand extends Command {
    public AddKeyboardCommand(Calculator calculator) {
        super(calculator);
    }

    @Override
    public void executeCommand() {
        calculator.packageKeyboard();
    }
}
