package com.pxy.designpattern.factorymethod;

import com.pxy.designpattern.decorator.ShowColor;
import com.pxy.designpattern.decorator.ShowRed;
import com.pxy.designpattern.simplefactory.Operation;
import com.pxy.designpattern.simplefactory.DivOperation;

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
