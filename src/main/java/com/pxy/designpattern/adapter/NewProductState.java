package com.pxy.designpattern.adapter;

import java.util.Calendar;
import java.util.Date;

public class NewProductState extends State {
    @Override
    public void setPrice(Calculator calculator,int basePrice) {
        Date productionDate = calculator.getProductionDate();
        if (isNew(productionDate)) {
            calculator.setPrice(basePrice);
        } else {
            changeState(calculator,basePrice);
        }
    }

    private boolean isNew(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.YEAR,1);
        Date dateCopy = calendar.getTime();
        return dateCopy.compareTo(new Date()) >= 0;
    }
    @Override
    protected void changeState(Calculator calculator,int basePrice) {
        calculator.setState(new SlightlyOldStateAdapter());
        calculator.setPriceByState(basePrice);
    }
}
