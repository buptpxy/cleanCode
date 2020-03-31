package com.pxy.designpattern.abstractfactory;

public class ModFactory implements OperateFactory {
    @Override
    public Operation newOperationInstance() {
        return new ModOperation();
    }

    @Override
    public ShowColor newShowColorInstance() {
        return new ShowYellow();
    }
}
