package com.pxy.designpattern.factorymethod;

import com.pxy.designpattern.decorator.ShowBlue;
import com.pxy.designpattern.decorator.ShowColor;
import com.pxy.designpattern.simplefactory.Operation;
import com.pxy.designpattern.simplefactory.SumOperation;

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
