package com.pxy.designpattern.adapter;

public class Client {
    /**
     * 使用状态模式来设置计算器的价格，使用适配器模式增加SlightlyOld状态，客户端代码不变，状态的变化流程写死在具体的State类中
     */
    public void setPriceByState(Calculator calculator) {
        int basePrice = 10;
        calculator.setPrice(basePrice);
    }
}
