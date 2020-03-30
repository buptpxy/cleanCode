package com.pxy.designpattern.interpreter;

//非终结符表达式
public abstract class OperationExpression extends Expression{
    protected Expression leftExpression;
    protected Expression rightExpression;
    public OperationExpression(Expression leftExpression,Expression rightExpression) {
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }
}
