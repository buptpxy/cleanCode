package com.pxy.designpattern.factorymethod;

public class SumFactory implements OperateFactory {
    @Override
    public Operation newOperationInstance() {
        return new SumOperation();
    }
}
