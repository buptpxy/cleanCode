package com.pxy.designpattern;

import com.pxy.designpattern.simplefactory.Operation;
import com.pxy.designpattern.simplefactory.OperationFactory;
import com.pxy.designpattern.strategy.OperationContext;

public class Computer {
    /**
     * 下面的函数实现了一个简易计算器，可实现加减乘除操作
     * 这个方法的缺点有：
     * 低可维护性、可扩展性：如果要增加其他运算形式需改现有逻辑，运算种类和运算逻辑耦合性较强
     * 低可复用性，代码只针对一种特殊场景，不能用于其他类似场景
     * 应使用面向对象的思维，重新实现一个计算器，使得修改其中一个运算逻辑无需知道其他运算逻辑的代码
     */
    public static int compute(int num1, String operator, int num2) throws Exception {
        switch (operator) {
            case "+":
                return num1+num2;
            case "-":
                return num1-num2;
            case "*":
                return num1*num2;
            case "/":
                if (num2 == 0) {
                    throw new Exception("除数不能为0");
                } else {
                    return num1/num2;
                }
            default:
                throw new Exception("运算符输入错误!");
        }
    }

    /**
     * 使用工厂模式的计算器，可方便的扩展其他操作运算，而无需更改已有操作运算的实现逻辑
     * 对任意一个操作类型的更改也不会影响其他操作
     */
    public static int computeByFactory(int num1, String operator, int num2) throws Exception {
        Operation operation = OperationFactory.createOperation(operator);
        return operation.operate(num1,num2);
    }

    /**
     * 客户端无需知道操作类对象和操作运算的实现，操作运算的实现与操作的调用完全解耦
     */
    public static int computeByStrategy(int num1, String operator, int num2) throws Exception {
        return OperationContext.execute(num1,operator,num2);
    }

}
