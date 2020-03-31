package com.pxy.designpattern.proxy;

public class Client {
    /**
     * 要知道指定暗号才能使用运算功能
     */
    public int computeByProxy(int num1, String operator, int num2) throws Exception {
        OperationContext operationContextProxy = new OperationContextProxy("芝麻开门");
        return operationContextProxy.execute(num1,operator,num2);
    }

}
