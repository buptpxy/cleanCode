package com.pxy.designpattern.interpreter;

import java.util.Map;

//终结符表达式
public class NumExpression extends Expression {
    private String numStr;
    public NumExpression(String numStr) {
        this.numStr = numStr;
    }
    @Override
    public int interpret(Map<String, Integer> expressionMap) {
        return expressionMap.get(numStr);
    }
}
