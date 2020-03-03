package com.pxy.designpattern.simplefactory;

import java.util.HashMap;
import java.util.Map;

public class OperationFactory {
    private static Map<String,Operation> operationMap = new HashMap<>();

    //如果要节约资源，每种类型的Operation对象只实例化一个的话，就调用此方法来返回操作对象
    public static Operation createOperation(String operator) throws Exception {
        if (operationMap.containsKey(operator)) {
            return operationMap.get(operator);
        }else {
            Operation operation = newOperationInstance(operator);
            operationMap.put(operator,operation);
            return operation;
        }
    }

    //如果要每次调用都返回新的操作对象，则直接调用此方法即可
    //虽然也使用了switch语句，但只是用来判断实例化哪个对象，并不会影响到对象内部的实现逻辑
    public static Operation newOperationInstance(String operator) throws Exception {
        switch (operator) {
            case "+":
                return new SumOperation();
            case "-":
                return new SubOperation();
            case "*":
                return new MulOperation();
            case "/":
                return new DivOperation();
            default:
                throw new Exception("运算符输入错误!");
        }
    }
}
