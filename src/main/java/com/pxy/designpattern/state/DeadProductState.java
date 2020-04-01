package com.pxy.designpattern.state;

import java.util.Calendar;
import java.util.Date;

public class DeadProductState extends State {
    @Override
    public void setPrice(Calculator calculator,int basePrice) {
        if (isDead(calculator.getProductionDate())) {
            calculator.setPrice(basePrice / 10);
        } else {
            calculator.setPrice(0);
        }
    }

    private boolean isDead(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.YEAR,5);
        Date dateCopy = calendar.getTime();
        return dateCopy.compareTo(new Date()) >= 0;
    }

    @Override
    protected void changeState(Calculator calculator,int basePrice) {
        calculator.setPriceByState(basePrice);
    }
}
