package com.pxy.designpattern.prototype;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Client {
    public List<Calculator> generateThreeCalculators() {
        List<Calculator> calculators = new ArrayList<>();
        Calendar productionDate = Calendar.getInstance();
        Calculator calculator1 = new Calculator();
        calculator1.setPrice(10);
        calculator1.setBrandName("卡西欧");
        calculator1.setColor("黑色");
        calculator1.setType("简单计算器");
        calculator1.setProductionDate(productionDate);
        calculators.add(calculator1);

        Calculator calculator2 = new Calculator();
        calculator2.setPrice(11);
        calculator2.setBrandName("卡西欧");
        calculator2.setColor("黑色");
        calculator2.setType("简单计算器");
        calculator2.setProductionDate(productionDate);
        calculators.add(calculator2);

        Calculator calculator3 = new Calculator();
        calculator3.setPrice(10);
        calculator3.setBrandName("卡东欧");
        calculator3.setColor("黑色");
        calculator3.setType("简单计算器");
        calculator3.setProductionDate(productionDate);
        calculators.add(calculator3);
        return calculators;
    }
    //使用原型模式拷贝计算器
    public List<Calculator> generateThreeCalculatorsByClone() throws CloneNotSupportedException {
        Calendar productionDate = Calendar.getInstance();
        List<Calculator> calculators = new ArrayList<>();
        Calculator calculator1 = new Calculator();
        calculator1.setPrice(10);
        calculator1.setBrandName("卡西欧");
        calculator1.setColor("黑色");
        calculator1.setType("简单计算器");
        calculator1.setProductionDate(productionDate);
        calculators.add(calculator1);

        //由于与calculator1中不同的price字段是非引用字段，故使用浅拷贝即可
        Calculator calculator2 = calculator1.clone();
        calculator2.setPrice(11);
        calculators.add(calculator2);

        //由于与calculator1中不同的brand字段是引用字段，故需使用深拷贝
        Calculator calculator3 = calculator1.deepClone();
        calculator3.setBrandName("卡东欧");
        calculators.add(calculator3);
        return calculators;
    }
}
