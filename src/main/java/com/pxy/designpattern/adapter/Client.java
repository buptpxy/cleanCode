package com.pxy.designpattern.adapter;

import java.util.Calendar;
import java.util.Date;

public class Client {
    /**
     * 使用状态模式来设置计算器的价格，使用适配器模式增加SlightlyOld状态，客户端代码不变，状态的变化流程写死在具体的State类中
     */
    public static void setPriceByState(Calculator calculator) {
        int basePrice = 10;
        calculator.setPriceByState(basePrice);
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Calendar productionDate = Calendar.getInstance();
        productionDate.add(Calendar.YEAR,-3);
        productionDate.add(Calendar.HOUR,1);
        Date date = productionDate.getTime();
        calculator.setProductionDate(date);

        setPriceByState(calculator);
        System.out.println(calculator.getPrice());
    }
}
