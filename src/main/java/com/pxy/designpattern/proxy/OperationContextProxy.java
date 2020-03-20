package com.pxy.designpattern.proxy;

public class OperationContextProxy implements OperationContext {
    public static final String PASSWORD = "芝麻开门";
    OperationContext operationContext;
    public OperationContextProxy(String password) throws Exception {
        if (isPasswordRight(password)) {
            System.out.println("口令正确，计算结果为：");
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
