package com.pxy.designpattern.state;

import java.util.Calendar;

public class Client {
    /**
     * 根据时间改变计算器的价格
     */
    public void setPriceByTime(Calculator calculator) {
        int basePrice = 10;
        Calendar productionDate = calculator.getProductionDate();
        Calendar turnOldDate = (Calendar) productionDate.clone();
        Calendar turnDeadDate = (Calendar) productionDate.clone();
        turnOldDate.add(Calendar.YEAR,1);//生产1年后
        turnDeadDate.add(Calendar.YEAR,3);//生产3年后
        Calendar now = Calendar.getInstance();
        if (now.before(turnOldDate)) {//判断状态
            calculator.setPrice(basePrice); //对应的业务逻辑
        }else if (now.before(turnDeadDate)) {
            calculator.setPrice(basePrice/2);
        }else {
            calculator.setPrice(basePrice/10);
        }
    }
    /**
     * 把状态改变的逻辑抽象出来
     */
    private void setProductStateValue(Calculator calculator) {
        Calendar productionDate = calculator.getProductionDate();
        Calendar turnOldDate = (Calendar) productionDate.clone();
        Calendar turnDeadDate = (Calendar) productionDate.clone();
        turnOldDate.add(Calendar.YEAR,1);//生产1年后
        turnDeadDate.add(Calendar.YEAR,3);//生产3年后
        Calendar now = Calendar.getInstance();
        if (now.before(turnOldDate)) {//判断状态
            calculator.setProductState(ProductState.NEW);
        }else if (now.before(turnDeadDate)) {
            calculator.setProductState(ProductState.OLD);
        }else {
            calculator.setProductState(ProductState.DEAD);
        }
    }

    public void setPriceByProductState(Calculator calculator) {
        int basePrice = 10;
        if (calculator.getProductState() == ProductState.NEW) {
            calculator.setPrice(basePrice);
        }else if (calculator.getProductState() == ProductState.OLD) {
            calculator.setPrice(basePrice/2);
        }else if (calculator.getProductState() == ProductState.DEAD) {
            calculator.setPrice(basePrice/10);
        }else {
            calculator.setPrice(0);
        }
    }

    /**
     * 使用状态模式来设置计算器的价格，使用适配器模式增加SlightlyOld状态，客户端代码不变，状态的变化流程写死在具体的State类中
     */
    public void setPriceByState(Calculator calculator) {
        int basePrice = 10;
        calculator.setPrice(basePrice);
    }
}
