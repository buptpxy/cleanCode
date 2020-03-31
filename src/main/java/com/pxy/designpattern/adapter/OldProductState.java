package com.pxy.designpattern.adapter;

import java.util.Calendar;

public class OldProductState extends State {
    @Override
    public void setPrice(Calculator calculator,int basePrice) {
        Calendar productionDate = calculator.getProductionDate();
        if (isOld(productionDate)) {
            calculator.setPrice(basePrice/2);
        } else {
//            changeState(calculator);
            if (nextState != null) {
                nextState.setPrice(calculator,basePrice);
            }
        }
    }

    private boolean isOld(Calendar date) {
        date.add(Calendar.YEAR,3);
        Calendar now = Calendar.getInstance();
        return now.before(date);
    }
    @Override
    protected void changeState(Calculator calculator) {
        calculator.setState(new DeadProductState());
    }
}
