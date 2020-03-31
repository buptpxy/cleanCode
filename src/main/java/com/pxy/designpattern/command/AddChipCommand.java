package com.pxy.designpattern.command;

public class AddChipCommand extends Command{
    public AddChipCommand(Calculator calculator) {
        super(calculator);
    }

    @Override
    public void executeCommand() {
        calculator.packageChip();
    }
}
