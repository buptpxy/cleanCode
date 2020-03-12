package com.pxy.designpattern.facade;

public class CalculatorPackager {
    private Chip chip;
    private Keyboard keyboard;
    private Screen screen;
    private Shell shell;
    public CalculatorPackager() {
        chip = new Chip();
        keyboard = new Keyboard();
        screen = new Screen();
        shell = new Shell();
    }
    public void packageCalculator(String shellColor) throws Exception {
        System.out.println("=======正在组装一个"+shellColor+"色的计算器=======");
        chip.packageChip();
        keyboard.packageKeyboard();
        screen.packageScreen();
        if ("红".equals(shellColor)) {
            shell.packageRedShell();
        }else if ("黑".equals(shellColor)) {
            shell.packageBlackShell();
        }else {
            throw new Exception("木有此种颜色的外壳，请选择\"红\"或\"黑\"色！");
        }
        System.out.println("======="+shellColor+"色的计算器组装完毕=======");
    }
}
