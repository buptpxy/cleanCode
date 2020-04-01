package com.pxy.designpattern.adapter;

import java.util.Calendar;
import java.util.Date;

public class SlightlyOldState {
    public void changePrice(Calculator calculator, int basePrice) {
        Date productionDate = calculator.getProductionDate();
        if (isSlightlyOld(productionDate)) {
            calculator.setPrice(basePrice/2);
        } else {
            changeState(calculator,basePrice);
        }
    }

    private boolean isSlightlyOld(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.YEAR,2);
        Date dateCopy = calendar.getTime();
        return dateCopy.compareTo(new Date()) >= 0;
    }

    protected void changeState(Calculator calculator,int basePrice) {
        calculator.setState(new OldProductState());
        calculator.setPriceByState(basePrice);
    }
}
