package com.pxy.designpattern.prototype;

import com.pxy.designpattern.Computer;
import org.junit.Assert;
import org.junit.Test;

public class CloneTests {
    /**
     * 第一种拷贝：直接赋值拷贝
     * 实际上拷贝的只是对象的引用，computer和computerClone指向同一个Computer对象
     */
    @Test
    public void testReferenceClone() {
        Computer computer = new Computer();
        computer.setBrandName("卡西欧");
        computer.setPrice(10);
        Computer computerClone = computer;

        //得到的computerClone的price和brandName与computer相同
        Assert.assertEquals("卡西欧",computerClone.getBrandName());
        Assert.assertEquals(10,computerClone.getPrice());

        //更改computerClone的price为11后，computer的price也变成了11
        computerClone.setPrice(11);
        Assert.assertEquals(11,computer.getPrice());

        //更改computerClone的brandName为"卡西欧copy"后，computer的brandName也变成了"卡西欧copy"
        computerClone.setBrandName("卡西欧copy");
        Assert.assertEquals("卡西欧copy",computer.getBrandName());
    }

    /**
     * 第二种拷贝：浅拷贝
     * 浅拷贝会创建一个新的Computer对象，然后将当前Computer对象的非静态字段复制到该新Computer对象
     * 不复制静态字段(static修饰的字段)是因为静态字段不属于这个类的任意一个实例化的对象的字段，而属于类的Class对象的字段，所以无需实例化即可调用静态字段
     * 对于值类型的字段，会直接复制该值
     * 对于引用类型的字段，会只复制该引用，复制后的引用和原引用实际上指向的是同一对象
     * 所有类的父类-Object类中的clone方法即是浅拷贝
     */
    @Test
    public void testClone() throws CloneNotSupportedException {
        Computer computer = new Computer();
        computer.setBrandName("卡西欧");
        computer.setPrice(10);
        Computer computerClone = computer.clone();

        //得到的computerClone的price和brandName与computer相同
        Assert.assertEquals("卡西欧",computerClone.getBrandName());
        Assert.assertEquals(10,computerClone.getPrice());

        //更改computerClone的price为11后，computer的price并不会变成11，仍然为10
        computerClone.setPrice(11);
        Assert.assertEquals(10,computer.getPrice());

        //更改computerClone的brandName为"卡西欧copy"后，computer的brandName也变成了"卡西欧copy"
        computerClone.setBrandName("卡西欧copy");
        Assert.assertEquals("卡西欧copy",computer.getBrandName());
    }

    /**
     * 第三种拷贝：深拷贝
     * 深拷贝不仅复制对象本身，而且复制对象包含的引用指向的所有对象。
     * Computer对象实现深拷贝时，Computer中的Brand对象也需实现深拷贝，因为Brand对象中可能还包含另一个需深拷贝的对象。
     * 在Java中深拷贝一个对象还有一种方式，就是先使对象实现 Serializable 接口，然后把对象写到一个流里，再从流里读出来的便是一个深拷贝的对象。
     */
    @Test
    public void testDeepClone() throws CloneNotSupportedException {
        Computer computer = new Computer();
        computer.setBrandName("卡西欧");
        computer.setPrice(10);
        Computer computerClone = computer.deepClone();

        //得到的computerClone的price和brandName与computer相同
        Assert.assertEquals("卡西欧",computerClone.getBrandName());
        Assert.assertEquals(10,computerClone.getPrice());

        //更改computerClone的price为11后，computer的price并不会变成11，仍然为10
        computerClone.setPrice(11);
        Assert.assertEquals(10,computer.getPrice());

        //更改computerClone的brandName为"卡西欧copy"后，computer的brandName不会变成"卡西欧copy"，仍然为"卡西欧"
        computerClone.setBrandName("卡西欧copy");
        Assert.assertEquals("卡西欧",computer.getBrandName());
    }
}
