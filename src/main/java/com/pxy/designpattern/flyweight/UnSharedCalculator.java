package com.pxy.designpattern.flyweight;

public class UnSharedCalculator extends Flyweight {
    @Override
    public int operate(ExternalNums externalNums) {
        return (externalNums.getNum1() - externalNums.getNum1() % externalNums.getNum2()) % externalNums.getNum2() ;
    }
}
