package com.pxy.designpattern.factorymethod;

public class DivFactory implements OperateFactory {
    @Override
    public Operation newOperationInstance() {
        return new DivOperation();
    }
}
