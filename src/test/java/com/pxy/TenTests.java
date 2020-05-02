package com.pxy;

import org.junit.Test;

public class TenTests {
    @Test
    public void testFloatAndDouble() {
        float a = 0.125f;
        double b = 0.125d;
        System.out.println((a - b) == 0.0);
    }
    @Test
    public void testDouble() {
        double c = 0.8;
        double d = 0.7;
        double e = 0.6;
        //c-d != d-e
        System.out.println(c-d);
        System.out.println(d-e);
//        所以浮点数比较时应设置在某一精度范围内比较
        System.out.println(Math.abs((c-d)-(d-e))<0.01);
    }
    @Test
    public void testDivZero() {
        System.out.println(1.0 / 0);
        System.out.println(0.0 / 0.0);
    }

    class TestOverloaded {
        void f(Integer i){};
        void f(Double d){};
    }

    @Test
    public void testOverloaded() {
        TestOverloaded overloaded = new TestOverloaded();
        overloaded.f(1);
    }

    @Test
    public void testSwitch() {
        String a = null;
        //报空指针异常
        switch (a) {
//            case null: //编译报错
//                System.out.println("null");
        }
    }

    <String, T, Alibaba> String get(String string, T t) {
        return string;
    }
}
