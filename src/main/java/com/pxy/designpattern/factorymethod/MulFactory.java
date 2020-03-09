package com.pxy.designpattern.factorymethod;

import com.pxy.designpattern.decorator.ShowColor;
import com.pxy.designpattern.decorator.ShowGreen;
import com.pxy.designpattern.simplefactory.Operation;
import com.pxy.designpattern.simplefactory.MulOperation;

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
