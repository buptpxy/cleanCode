package com.pxy.designpattern.strategy;

public interface OperationContext {

    int execute(int num1, String operator, int num2) throws Exception ;
}
