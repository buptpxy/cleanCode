package com.pxy.designpattern.memento;

import java.util.Calendar;

public class DeadProductState extends State {
    @Override
    public void setPrice(Calculator calculator,int basePrice) {
        if (isDead(calculator.getProductionDate())) {
            calculator.setPrice(basePrice / 10);
        } else {
            if (nextState != null) {
                nextState.setPrice(calculator,basePrice);
            }
        }
    }

    private boolean isDead(Calendar date) {
        date.add(Calendar.YEAR,5);
        Calendar now = Calendar.getInstance();
        return now.after(date);
    }

    @Override
    protected void changeState(Calculator calculator) {

    }
}
