package com.pxy.designpattern.flyweight;

import java.util.HashMap;
import java.util.Map;

public class CalculatorFactory {
    private static Map<String, Flyweight> calculatorInstanceMap = new HashMap<>();
    public static Flyweight getInstance(String operation) {
        if (calculatorInstanceMap.get(operation)==null) {
            calculatorInstanceMap.put(operation,new SharedCalculator(operation));
        }
        return calculatorInstanceMap.get(operation);
    }
    public static int instanceCount() {
        return calculatorInstanceMap.size();
    }
}
