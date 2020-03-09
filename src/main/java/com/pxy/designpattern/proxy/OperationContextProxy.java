package com.pxy.designpattern.proxy;

import com.pxy.designpattern.strategy.OperationContext;
import com.pxy.designpattern.strategy.OperationContextImpl;

public class OperationContextProxy implements OperationContext {
    public static final String PASSWORD = "芝麻开门";
    OperationContext operationContext;
    public OperationContextProxy(String password) throws Exception {
        if (isPasswordRight(password)) {
            if (operationContext == null) {
                operationContext = new OperationContextImpl();
            }
        }else {
            throw new Exception("口令错误！");
        }
    }

    private boolean isPasswordRight(String password) {
        return password.equals(PASSWORD);
    }

    @Override
    public int execute(int num1, String operator, int num2) throws Exception {
        return operationContext.execute(num1,operator,num2);
    }
}
