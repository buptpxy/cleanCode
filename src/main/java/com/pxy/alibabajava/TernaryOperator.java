package com.pxy.alibabajava;

/**
 * @author pengxueyin
 */
public class TernaryOperator {
    public static void main(String[] args) {
        Integer a = 1;
        Integer b = 2;
        Integer c = null;
        Boolean flag = false;
        //容易引起由于自动拆箱造成的空指针异常
        Integer result = (flag ?  a * b  :  c);
        System.out.println(result);
    }
}
