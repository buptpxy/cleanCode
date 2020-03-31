package com.pxy.designpattern.builder;

public class BuilderDirector {
    private CalculatorBuilder calculatorBuilder;
    public BuilderDirector(CalculatorBuilder calculatorBuilder) {
        this.calculatorBuilder = calculatorBuilder;
    }
    public Calculator buildCalculator() {
        calculatorBuilder.buildChip();
        calculatorBuilder.buildScreen();
        calculatorBuilder.buildKeyboard();
        calculatorBuilder.buildShell();
        return calculatorBuilder.packageCalculator();
    }
}
