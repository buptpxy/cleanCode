package com.pxy.designpattern.abstractfactory;

public class Client {
    /**
     * 抽象工厂模式实现一系列有关联的方法的调用
     */
    public static int computeByAbstractFactory(int num1, String operator, int num2) throws Exception {
        OperateFactory operateFactory;
        switch (operator) {
            case "+":
                operateFactory = new SumFactory();
                break;
            case "-":
                operateFactory = new SubFactory();
                break;
            case "*":
                operateFactory = new MulFactory();
                break;
            case "/":
                operateFactory = new DivFactory();
                break;
            case "%":
                operateFactory = new ModFactory();
                break;
            default:
                throw new Exception("运算符输入错误!");
        }
        ShowColor showColor = operateFactory.newShowColorInstance();
        showColor.showColor();
        showColor.setCalculator(new Calculator());
        return showColor.compute(num1,operator,num2);
    }

    public static void main(String[] args) {
        try {
            System.out.println(computeByAbstractFactory(2,"/",1));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
