package com.pxy.designpattern.templateMethod;

public class Client {

    /**
     * 与装饰模式的客户端代码相同
     */
    public static int computeByTemplateMethod(int num1, String operator, int num2, String[] colors) throws Exception {
        Calculator calculator = new Calculator();
        ShowColor showColor = ShowColorFactory.newShowColorInstance(colors[0]);
        showColor.setCalculator(calculator);
        for (int i = 1; i < colors.length; i++) {
            ShowColor showColorI = ShowColorFactory.newShowColorInstance(colors[i]);
            showColorI.setCalculator(showColor);
            showColor = showColorI;
        }
        return showColor.compute(num1,operator,num2);
    }

    public static void main(String[] args) {
        try {
            System.out.println(computeByTemplateMethod(2,"/",1, new String[]{"red", "blue", "yellow"}));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
