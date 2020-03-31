package com.pxy.designpattern.responsibility;

public class Client {
    /**
     * 使用职责链模式来设置计算器的价格，在客户端来配置状态的变化流程
     */
    public void setPriceByResponsibility(Calculator calculator) {
        int basePrice = 10;
        State newState = new NewProductState();
        State slightlyOldState = new SlightlyOldStateAdapter();
        State oldState = new OldProductState();
        State deadState = new DeadProductState();
        newState.setNextState(slightlyOldState);
        slightlyOldState.setNextState(oldState);
        oldState.setNextState(deadState);

        calculator.setState(newState);
        calculator.setPrice(basePrice);
    }
}
