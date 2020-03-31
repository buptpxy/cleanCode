package com.pxy.designpattern.factorymethod;

public class ModFactory implements OperateFactory {
    @Override
    public Operation newOperationInstance() {
        return new ModOperation();
    }
}
