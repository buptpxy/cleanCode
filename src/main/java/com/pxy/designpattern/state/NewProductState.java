package com.pxy.designpattern.state;

import com.pxy.designpattern.Calculator;
import com.pxy.designpattern.adapter.SlightlyOldStateAdapter;

import java.util.Calendar;

public class NewProductState extends State {
    @Override
    public void setPrice(Calculator calculator,int basePrice) {
        Calendar productionDate = calculator.getProductionDate();
        if (isNew(productionDate)) {
            calculator.setPrice(basePrice);
        } else {
//            changeState(calculator);
            if (nextState != null) {
                nextState.setPrice(calculator,basePrice);
            }
        }
    }

    private boolean isNew(Calendar date) {
        date.add(Calendar.YEAR,1);
        Calendar now = Calendar.getInstance();
        return now.before(date);
    }
    @Override
    protected void changeState(Calculator calculator) {
        calculator.setState(new SlightlyOldStateAdapter());
    }
}
