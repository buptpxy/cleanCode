package com.pxy.designpattern.interpreter;

import java.util.Map;
import java.util.Stack;

import static java.lang.Character.isLetter;

public class SimpleCalculator {
    private Stack<Expression> numberStack = new Stack<>();
    private Map<String,Integer> expressionMap;
    private Expression leftExpression;
    private Expression rightExpression;
    private NumExpression numExpression;
    public SimpleCalculator(Map<String,Integer> expressionMap) {
        this.expressionMap = expressionMap;
    }
    public int compute(char[] formula) throws Exception {
        int index = 0;
        while (index < formula.length-1) {
            if (isLetter(formula[index])) {
                numExpression = new NumExpression(String.valueOf(formula[index]));
                numberStack.push(numExpression);
            } else {
                leftExpression = numberStack.pop();
                rightExpression = new NumExpression(String.valueOf(formula[index+1]));
                OperationExpression operationExpression = getOperationExpression(formula[index]);
                numberStack.push(operationExpression);
                index++;//下个num已经被使用过了，需跳过
            }
            index++;
        }
        return numberStack.pop().interpret(expressionMap);
    }

    private OperationExpression getOperationExpression(char operationChr) throws Exception {
        switch (operationChr) {
            case '+' :
                return new SumExpression(leftExpression, rightExpression);
            case '-' :
                return new SubExpression(leftExpression, rightExpression);
            default:
                throw new Exception("暂不支持的运算符 " + operationChr);
        }
    }
}
