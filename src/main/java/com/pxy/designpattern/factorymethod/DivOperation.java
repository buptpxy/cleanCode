package com.pxy.designpattern.factorymethod;

public class DivOperation extends Operation {
    @Override
    public int operate(int operateNum1, int operateNum2) throws Exception {
        if (operateNum2 == 0) {
            throw new Exception("除数不能为0");
        }
        return operateNum1/operateNum2;
    }
}
