package com.pxy.designpattern.interpreter;

import java.util.Map;

public class SumExpression extends OperationExpression {
    public SumExpression(Expression leftExpression, Expression rightExpression) {
        super(leftExpression, rightExpression);
    }

    //也不算严格的递归，因为leftExpression和rightExpression的interpret方法未递归调用，否则必须给定递归终止条件
    @Override
    public int interpret(Map<String, Integer> expressionMap) {
        return leftExpression.interpret(expressionMap) + rightExpression.interpret(expressionMap);
    }
}
