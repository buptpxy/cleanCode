package com.pxy.designpattern.factorymethod;

public class MulOperation extends Operation {
    @Override
    public int operate(int operateNum1, int operateNum2) {
        return operateNum1*operateNum2;
    }
}
