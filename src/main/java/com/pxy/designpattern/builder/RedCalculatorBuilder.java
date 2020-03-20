package com.pxy.designpattern.builder;

import com.pxy.designpattern.Calculator;
import com.pxy.designpattern.facade.Chip;
import com.pxy.designpattern.facade.Keyboard;
import com.pxy.designpattern.facade.Screen;
import com.pxy.designpattern.facade.Shell;

public class RedCalculatorBuilder extends CalculatorBuilder {
    private Calculator calculator = new Calculator();

    @Override
    public void buildChip() {
        Chip chip = new Chip();
        chip.packageChip();
        calculator.setChip(chip);
    }

    @Override
    public void buildScreen() {
        Screen screen = new Screen();
        screen.packageScreen();
        calculator.setScreen(screen);
    }

    @Override
    public void buildKeyboard() {
        Keyboard keyboard = new Keyboard();
        keyboard.packageKeyboard();
        calculator.setKeyboard(keyboard);
    }

    @Override
    public void buildShell() {
        Shell shell = new Shell();
        shell.packageRedShell();
        calculator.setShell(shell);
    }

    @Override
    public Calculator packageCalculator() {
        return calculator;
    }
}