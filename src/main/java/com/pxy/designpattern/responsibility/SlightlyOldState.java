package com.pxy.designpattern.responsibility;

import java.util.Calendar;

public class SlightlyOldState {
    private State nextState;
    public void changePrice(Calculator calculator, int basePrice) {
        Calendar productionDate = calculator.getProductionDate();
        if (isSlightlyOld(productionDate)) {
            calculator.setPrice(basePrice/2);
        } else {
//            changeState(calculator);
            if (nextState!=null) {
                nextState.setPrice(calculator,basePrice);
            }
        }
    }

    private boolean isSlightlyOld(Calendar date) {
        date.add(Calendar.YEAR,2);
        Calendar now = Calendar.getInstance();
        return now.before(date);
    }

    protected void changeState(Calculator calculator) {
        calculator.setState(new OldProductState());
    }
}
