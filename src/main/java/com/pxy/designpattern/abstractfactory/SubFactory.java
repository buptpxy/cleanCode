package com.pxy.designpattern.abstractfactory;

public class SubFactory implements OperateFactory {
    @Override
    public Operation newOperationInstance() {
        return new SubOperation();
    }

    @Override
    public ShowColor newShowColorInstance() {
        return new ShowBlack();
    }
}
