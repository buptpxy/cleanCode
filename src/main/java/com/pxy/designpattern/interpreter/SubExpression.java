package com.pxy.designpattern.interpreter;

import java.util.Map;

public class SubExpression extends OperationExpression {
    public SubExpression(Expression leftExpression, Expression rightExpression) {
        super(leftExpression, rightExpression);
    }

    @Override
    public int interpret(Map<String, Integer> expressionMap) {
        return leftExpression.interpret(expressionMap) - rightExpression.interpret(expressionMap);
    }
}
