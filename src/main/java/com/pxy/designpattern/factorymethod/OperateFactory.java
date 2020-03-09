package com.pxy.designpattern.factorymethod;

import com.pxy.designpattern.decorator.ShowColor;
import com.pxy.designpattern.simplefactory.Operation;

public interface OperateFactory {
    Operation newOperationInstance();
    ShowColor newShowColorInstance();
}
