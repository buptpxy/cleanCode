package com.pxy.designpattern.proxy;

public class DivOperation extends Operation {
    @Override
    public int operate(int opreateNum1, int opreateNum2) throws Exception {
        if (opreateNum2 == 0) {
            throw new Exception("除数不能为0");
        }
        return opreateNum1/opreateNum2;
    }
}
