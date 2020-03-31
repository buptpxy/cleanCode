package com.pxy.designpattern.abstractfactory;

public class MulFactory implements OperateFactory {
    @Override
    public Operation newOperationInstance() {
        return new MulOperation();
    }

    @Override
    public ShowColor newShowColorInstance() {
        return new ShowGreen();
    }
}
