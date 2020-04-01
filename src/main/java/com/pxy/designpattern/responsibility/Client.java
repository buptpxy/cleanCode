package com.pxy.designpattern.responsibility;

import java.util.Calendar;
import java.util.Date;

public class Client {
    /**
     * 使用职责链模式来设置计算器的价格，在客户端来配置状态的变化流程
     */
    public static void setPriceByResponsibility(Calculator calculator) {
        int basePrice = 10;
        State newState = new NewProductState();
        State slightlyOldState = new SlightlyOldStateAdapter();
        State oldState = new OldProductState();
        State deadState = new DeadProductState();
        newState.setNextState(slightlyOldState);
        slightlyOldState.setNextState(oldState);
        oldState.setNextState(deadState);

        calculator.setState(newState);
        calculator.setPriceByState(basePrice);
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Calendar productionDate = Calendar.getInstance();
        productionDate.add(Calendar.YEAR,-3);
        productionDate.add(Calendar.HOUR,1);
        Date date = productionDate.getTime();
        calculator.setProductionDate(date);

        setPriceByResponsibility(calculator);
        System.out.println(calculator.getPrice());
    }
}
