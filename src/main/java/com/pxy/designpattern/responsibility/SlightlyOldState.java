package com.pxy.designpattern.responsibility;

import java.util.Calendar;
import java.util.Date;

public class SlightlyOldState {
    private State nextState;
    public void setNextState(State nextState) {
        this.nextState = nextState;
    }
    public void changePrice(Calculator calculator, int basePrice) {
        Date productionDate = calculator.getProductionDate();
        if (isSlightlyOld(productionDate)) {
            calculator.setPrice(basePrice/2);
        } else {
            if (nextState!=null) {
                nextState.setPrice(calculator,basePrice);
            }
        }
    }

    private boolean isSlightlyOld(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.YEAR,2);
        Date dateCopy = calendar.getTime();
        return dateCopy.compareTo(new Date()) >= 0;
    }
}
