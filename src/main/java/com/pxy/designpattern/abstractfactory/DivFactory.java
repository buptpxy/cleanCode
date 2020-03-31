package com.pxy.designpattern.abstractfactory;

public class DivFactory implements OperateFactory {
    @Override
    public Operation newOperationInstance() {
        return new DivOperation();
    }

    @Override
    public ShowColor newShowColorInstance() {
        return new ShowRed();
    }
}
