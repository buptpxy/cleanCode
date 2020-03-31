package com.pxy.designpattern.facade;

public class Client {
    private static void packageCalculator() {
        Chip chip = new Chip();
        Keyboard keyboard = new Keyboard();
        Screen screen = new Screen();
        Shell shell = new Shell();

        System.out.println("=======正在组装一个红色的计算器=======");
        chip.packageChip();
        keyboard.packageKeyboard();
        screen.packageScreen();
        shell.packageRedShell();
        System.out.println("=======红色的计算器组装完毕=======");

        System.out.println("=======正在组装一个黑色的计算器=======");
        chip.packageChip();
        keyboard.packageKeyboard();
        screen.packageScreen();
        shell.packageBlackShell();
        System.out.println("=======黑色的计算器组装完毕=======");
    }

    /**
     * 使用外观模式组装计算器
     */
    public static void packageCalculatorByFacade() throws Exception {
        CalculatorPackager calculatorPackager = new CalculatorPackager();
        calculatorPackager.packageCalculator("红");
        calculatorPackager.packageCalculator("黑");
    }

    public static void main(String[] args) {
        try {
            packageCalculatorByFacade();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
