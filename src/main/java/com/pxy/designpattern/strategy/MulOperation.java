package com.pxy.designpattern.strategy;

public class MulOperation extends Operation {
    @Override
    public int operate(int opreateNum1, int opreateNum2) {
        return opreateNum1*opreateNum2;
    }
}
