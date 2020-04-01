package com.pxy.designpattern.state;

import java.util.Calendar;
import java.util.Date;

public class Client {
    /**
     * 根据时间改变计算器的价格
     */
    public static void setPriceByTime(Calculator calculator) {
        int basePrice = 10;
        Date productionDate = calculator.getProductionDate();
        Calendar oldTime = Calendar.getInstance();
        oldTime.setTime(productionDate);
        oldTime.add(Calendar.YEAR,1);//生产1年后
        Date turnOldDate = oldTime.getTime();

        Calendar deadTime = Calendar.getInstance();
        deadTime.setTime(productionDate);
        deadTime.add(Calendar.YEAR,3);//生产3年后
        Date turnDeadDate = deadTime.getTime();

        Date now = new Date();
        if (now.compareTo(turnOldDate) <= 0) {//判断状态
            calculator.setPrice(basePrice); //对应的业务逻辑
        }else if (now.compareTo(turnDeadDate) <= 0) {
            calculator.setPrice(basePrice/3);
        }else {
            calculator.setPrice(basePrice/10);
        }
    }

    /**
     * 把状态改变的逻辑抽象出来，放到Calculator类中，使用枚举类来代表生产日期状态
     */
    public static void setPriceByProductState(Calculator calculator) {
        int basePrice = 10;
        if (calculator.getProductState() == ProductState.NEW) {
            calculator.setPrice(basePrice);
        }else if (calculator.getProductState() == ProductState.OLD) {
            calculator.setPrice(basePrice/3);
        }else if (calculator.getProductState() == ProductState.DEAD) {
            calculator.setPrice(basePrice/10);
        }else {
            calculator.setPrice(0);
        }
    }
    /**
     * 使用状态模式来设置计算器的价格
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
        //根据时间改变计算器的价格
//        setPriceByTime(calculator);
        //根据状态改变计算器的价格
        calculator.setProductState();
        setPriceByProductState(calculator);
        //使用状态模式来设置计算器的价格
//        setPriceByState(calculator);
        System.out.println(calculator.getPrice());
    }
}
