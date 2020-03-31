package com.pxy.designpattern.factorymethod;

public class SubFactory implements OperateFactory {
    @Override
    public Operation newOperationInstance() {
        return new SubOperation();
    }
}
