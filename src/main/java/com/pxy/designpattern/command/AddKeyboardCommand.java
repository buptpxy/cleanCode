package com.pxy.designpattern.command;

import com.pxy.designpattern.Calculator;

public class AddKeyboardCommand extends Command {
    public AddKeyboardCommand(Calculator calculator) {
        super(calculator);
    }

    @Override
    public void executeCommand() {
        calculator.packageKeyboard();
    }
}
