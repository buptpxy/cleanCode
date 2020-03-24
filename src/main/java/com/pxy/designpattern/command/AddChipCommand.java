package com.pxy.designpattern.command;

import com.pxy.designpattern.Calculator;

public class AddChipCommand extends Command{
    public AddChipCommand(Calculator calculator) {
        super(calculator);
    }

    @Override
    public void executeCommand() {
        calculator.packageChip();
    }
}
