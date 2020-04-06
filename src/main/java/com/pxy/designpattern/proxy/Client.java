package com.pxy.designpattern.proxy;

import java.lang.reflect.Proxy;

public class Client {
    /**
     * 要知道指定暗号才能使用运算功能
     */
    public static int computeByProxy(int num1, String operator, int num2,String password) throws Exception {
        OperationContext operationContextProxy = new OperationContextProxy(password);
        return operationContextProxy.execute(num1,operator,num2);
    }

    public static int computeByDynamicProxy(int num1, String operator, int num2 , String password) throws Exception {
        // 设置环境变量保存动态代理类，默认名称以 $Proxy0 格式命名
         System.getProperties().setProperty("jdk.proxy.ProxyGenerator.saveGeneratedFiles", "true");

        // 1. 创建被代理的对象，OperationContext接口的实现类
        OperationContextImpl operationContextImpl = new OperationContextImpl();
        // 2. 获取对应的 ClassLoader
        ClassLoader classLoader = operationContextImpl.getClass().getClassLoader();
        // 3. 获取operationContextImpl实现的所有接口的Class对象，这里的OperationContextImpl只实现了一个接口OperationContext
        Class[] interfaces = operationContextImpl.getClass().getInterfaces();
        // 4. 创建一个将传给代理类的调用请求处理器，处理所有的代理对象上的方法调用
        //     这里创建的是一个自定义的口令处理器，须传入被代理的对象 operationContextImpl

        PasswordHandler passwordHandler = new PasswordHandler(operationContextImpl,password);
        /*
           5.根据上面提供的信息，创建代理对象
           在这个过程中:
               a.JDK会通过根据传入的参数信息动态地在内存中创建和.class 文件等同的字节码
               b.然后根据相应的字节码转换成对应的class，
               c.然后调用newInstance()创建代理实例
         */
        OperationContext operationContextProxy = (OperationContext) Proxy.newProxyInstance(classLoader,interfaces,passwordHandler);
        // 通过调用代理的方法来调用被代理类的方法
        return operationContextProxy.execute(num1,operator,num2);
    }

    public static void main(String[] args) {
        try {
            System.out.println(computeByProxy(2,"/",1,"芝麻开门"));
            System.out.println(computeByDynamicProxy(2,"/",1,"芝麻开门"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
