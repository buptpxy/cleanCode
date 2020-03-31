package com.pxy.designpattern.decorator;

public class Client {

    /**
     * 给计算器计算结果的时候增加打印颜色的功能，使用装饰模式。这样无论要打印多少种颜色和按何种顺序打印，都可由参数colors指定，也不影响原来的计算功能
     */
    public int computeByDecorator(int num1, String operator, int num2, String[] colors) throws Exception {
        Calculator calculator = new Calculator();
        ShowColor showColor = ShowColorFactory.newShowColorInstance(colors[0]);
        showColor.setCalculator(calculator);
        for (int i = 1; i < colors.length; i++) {
            ShowColor showColorI = ShowColorFactory.newShowColorInstance(colors[i]);
            showColorI.setCalculator(showColor);
            showColorI.showColor();
            showColor = showColorI;
        }
        return showColor.compute(num1,operator,num2);
    }
}
