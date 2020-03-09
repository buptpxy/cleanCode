package com.pxy.designpattern.factorymethod;

import com.pxy.designpattern.decorator.ShowColor;
import com.pxy.designpattern.decorator.ShowYellow;
import com.pxy.designpattern.simplefactory.Operation;

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
