package com.pxy.designpattern.adapter;

import java.util.Calendar;
import java.util.Date;

public class OldProductState extends State {
    @Override
    public void setPrice(Calculator calculator,int basePrice) {
        Date productionDate = calculator.getProductionDate();
        if (isOld(productionDate)) {
            calculator.setPrice(basePrice/3);
        } else {
            changeState(calculator,basePrice);
        }
    }

    private boolean isOld(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.YEAR,3);
        Date dateCopy = calendar.getTime();
        return dateCopy.compareTo(new Date()) >= 0;
    }
    @Override
    protected void changeState(Calculator calculator,int basePrice) {
        calculator.setState(new DeadProductState());
        calculator.setPriceByState(basePrice);
    }
}
