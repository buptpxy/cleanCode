package com.pxy.designpattern.simplefactory;

public class Client {
    /**
     * 使用工厂模式的计算器，可方便的扩展其他操作运算，而无需更改已有操作运算的实现逻辑
     * 对任意一个操作类型的更改也不会影响其他操作
     */
    public static int computeByFactory(int num1, String operator, int num2) throws Exception {
        Operation operation = OperationFactory.createOperation(operator);
        return operation.operate(num1,num2);
    }

    public static void main(String[] args) {
        try {
            System.out.println(computeByFactory(2,"/",1));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
