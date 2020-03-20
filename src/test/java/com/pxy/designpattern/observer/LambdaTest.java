package com.pxy.designpattern.observer;

import org.junit.Assert;
import org.junit.Test;

public class LambdaTest {
    //Event接口只能有一个方法，否则将无法通过lambda表达式后::操作符找到此方法
    //@FunctionalInterface 注解要求接口有且只有一个抽象方法
    @FunctionalInterface
    interface Event {
        int handleEvent(int a,int b);
    }
    private int add(int a,int b) {
        return a+b;
    }
    @Test
    public void testLambda() {
        //这里使用的lambda表达式，与使用::操作符等价，可以将一个类的方法赋值给另一个接口的方法，相当于实现了这个接口的方法，但这两个方法参数类型、个数要相同
        Event event = (a,b)->add(a,b);
//        Event event = this::add;
        int result = event.handleEvent(1,2);
        Assert.assertEquals(result,3);
    }
}
