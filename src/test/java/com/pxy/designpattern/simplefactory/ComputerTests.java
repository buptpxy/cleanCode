package com.pxy.designpattern.simplefactory;

import com.pxy.designpattern.Computer;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ComputerTests {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testDivideZero() throws Exception {
        expectedException.expectMessage("除数不能为0");
//        Computer.compute(1,"/",0);
        Computer.computeByFactory(1,"/",0);
    }

    @Test
    public void testOptionNotMatch() throws Exception {
        expectedException.expectMessage("运算符输入错误!");
//        Computer.compute(1,"=",0);
        Computer.computeByFactory(1,"=",0);
    }

    @Test
    public void testAdd() throws Exception {
//        int result = Computer.compute(3,"+",2);
        int result = Computer.computeByFactory(3,"+",2);
        Assert.assertEquals(5,result);
    }
    @Test
    public void testSub() throws Exception {
//        int result = Computer.compute(3,"-",2);
        int result = Computer.computeByFactory(3,"-",2);
        Assert.assertEquals(1,result);
    }
    @Test
    public void testMul() throws Exception {
//        int result = Computer.compute(3,"*",2);
        int result = Computer.computeByFactory(3,"*",2);
        Assert.assertEquals(6,result);
    }
    @Test
    public void testDiv() throws Exception {
//        int result = Computer.compute(3,"/",2);
        int result = Computer.computeByFactory(3,"/",2);
        Assert.assertEquals(1,result);
    }
}
