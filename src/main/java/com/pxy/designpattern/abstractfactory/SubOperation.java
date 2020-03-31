package com.pxy.designpattern.abstractfactory;

public class SubOperation extends Operation {
    @Override
    public int operate(int opreateNum1, int opreateNum2) {
        return opreateNum1-opreateNum2;
    }
}
