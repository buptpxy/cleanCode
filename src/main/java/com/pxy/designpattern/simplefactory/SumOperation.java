package com.pxy.designpattern.simplefactory;

public class SumOperation extends Operation {
    @Override
    public int operate(int opreateNum1, int opreateNum2) {
        return opreateNum1+opreateNum2;
    }
}
