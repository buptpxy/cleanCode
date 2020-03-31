package com.pxy.designpattern.factorymethod;

public class Client {
    /**
     * 增加新操作类型时增加对应的工厂类即可，无需更改原有工厂类代码。
     * 但对工厂类型的使用判断放到客户端中了，增加了客户端的复杂度。且每新增一种操作就要新增两个类，代码量增加较多。
     * 所以只在实例化对象的逻辑比较复杂、新增新的操作类型的需求较频繁时，才推荐使用工厂方法模式
     */
    public static int computeByFactoryMethod(int num1, String operator, int num2) throws Exception {
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
        Operation operation = operateFactory.newOperationInstance();
        return operation.operate(num1,num2);
    }

    public static void main(String[] args) {
        try {
            System.out.println(computeByFactoryMethod(2,"/",1));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
