package com.pxy.designpattern.abstractfactory;

public interface OperateFactory {
    Operation newOperationInstance();
    ShowColor newShowColorInstance();
}
