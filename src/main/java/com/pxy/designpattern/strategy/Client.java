package com.pxy.designpattern.strategy;

public class Client {
    /**
     * 客户端无需知道操作类对象和操作运算的实现，操作运算的实现与操作的调用完全解耦
     */
    public static int computeByStrategy(int num1, String operator, int num2) throws Exception {
        OperationContext operationContext = new OperationContextImpl();
        return operationContext.execute(num1,operator,num2);
    }

    public static void main(String[] args) {
        try {
            System.out.println(computeByStrategy(3,"/",2));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
