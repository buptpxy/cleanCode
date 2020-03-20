package com.pxy.designpattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class PasswordHandler implements InvocationHandler {
    private static final String PASSWORD = "芝麻开门";
    private Object target;
    private String password;
    public PasswordHandler(Object target,String password) {
        this.target = target;
        this.password = password;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (isPasswordRight(password)) {
            System.out.println("口令正确，计算结果为：");
            return method.invoke(target,args);
        } else {
            throw new Exception("口令错误！");
        }
    }
    private boolean isPasswordRight(String password) {
        return password.equals(PASSWORD);
    }
}
