package com.pxy.designpattern.prototype;

import org.junit.Assert;
import org.junit.Test;

public class CloneTests {
    /**
     * 第一种拷贝：直接赋值拷贝
     * 实际上拷贝的只是对象的引用，calculator和calculatorClone指向同一个Calculator对象
     */
    @Test
    public void testReferenceClone() {
        Calculator calculator = new Calculator();
        calculator.setBrandName("卡西欧");
        calculator.setPrice(10);
        Calculator calculatorClone = calculator;

        //得到的calculatorClone的price和brandName与calculator相同
        Assert.assertEquals("卡西欧", calculatorClone.getBrand());
        Assert.assertEquals(10, calculatorClone.getPrice());

        //更改calculatorClone的price为11后，calculator的price也变成了11
        calculatorClone.setPrice(11);
        Assert.assertEquals(11, calculator.getPrice());

        //更改calculatorClone的brandName为"卡西欧copy"后，calculator的brandName也变成了"卡西欧copy"
        calculatorClone.setBrandName("卡西欧copy");
        Assert.assertEquals("卡西欧copy", calculator.getBrand());
    }

    /**
     * 第二种拷贝：浅拷贝
     * 浅拷贝会创建一个新的Calculator对象，然后将当前Calculator对象的非静态字段复制到该新Calculator对象
     * 不复制静态字段(static修饰的字段)是因为静态字段不属于这个类的任意一个实例化的对象的字段，而属于类的Class对象的字段，所以无需实例化即可调用静态字段
     * 对于值类型的字段，会直接复制该值
     * 对于引用类型的字段，会只复制该引用，复制后的引用和原引用实际上指向的是同一对象
     * 所有类的父类-Object类中的clone方法即是浅拷贝
     */
    @Test
    public void testClone() throws CloneNotSupportedException {
        Calculator calculator = new Calculator();
        calculator.setBrandName("卡西欧");
        calculator.setPrice(10);
        Calculator calculatorClone = calculator.clone();

        //得到的calculatorClone的price和brandName与calculator相同
        Assert.assertEquals("卡西欧", calculatorClone.getBrand());
        Assert.assertEquals(10, calculatorClone.getPrice());

        //更改calculatorClone的price为11后，calculator的price并不会变成11，仍然为10
        calculatorClone.setPrice(11);
        Assert.assertEquals(10, calculator.getPrice());

        //更改calculatorClone的brandName为"卡西欧copy"后，calculator的brandName也变成了"卡西欧copy"
        calculatorClone.setBrandName("卡西欧copy");
        Assert.assertEquals("卡西欧copy", calculator.getBrand());
    }

    /**
     * 第三种拷贝：深拷贝
     * 深拷贝不仅复制对象本身，而且复制对象包含的引用指向的所有对象。
     * Calculator对象实现深拷贝时，Calculator中的Brand对象也需实现深拷贝，因为Brand对象中可能还包含另一个需深拷贝的对象。
     * 在Java中深拷贝一个对象还有一种方式，就是先使对象实现 Serializable 接口，然后把对象写到一个流里，再从流里读出来的便是一个深拷贝的对象。
     */
    @Test
    public void testDeepClone() throws CloneNotSupportedException {
        Calculator calculator = new Calculator();
        calculator.setBrandName("卡西欧");
        calculator.setPrice(10);
        Calculator calculatorClone = calculator.deepClone();

        //得到的calculatorClone的price和brandName与calculator相同
        Assert.assertEquals("卡西欧", calculatorClone.getBrand());
        Assert.assertEquals(10, calculatorClone.getPrice());

        //更改calculatorClone的price为11后，calculator的price并不会变成11，仍然为10
        calculatorClone.setPrice(11);
        Assert.assertEquals(10, calculator.getPrice());

        //更改calculatorClone的brandName为"卡西欧copy"后，calculator的brandName不会变成"卡西欧copy"，仍然为"卡西欧"
        calculatorClone.setBrandName("卡西欧copy");
        Assert.assertEquals("卡西欧", calculator.getBrand());
    }
}
