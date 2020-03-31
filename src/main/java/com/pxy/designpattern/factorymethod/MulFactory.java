package com.pxy.designpattern.factorymethod;

public class MulFactory implements OperateFactory {
    @Override
    public Operation newOperationInstance() {
        return new MulOperation();
    }
}
