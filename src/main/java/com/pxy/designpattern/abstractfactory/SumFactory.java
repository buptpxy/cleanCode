package com.pxy.designpattern.abstractfactory;

public class SumFactory implements OperateFactory {
    @Override
    public Operation newOperationInstance() {
        return new SumOperation();
    }
    @Override
    public ShowColor newShowColorInstance() {
        return new ShowBlue();
    }
}
