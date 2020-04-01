package com.pxy.designpattern.responsibility;

import java.util.Calendar;
import java.util.Date;

public class OldProductState extends State {
    @Override
    public void setPrice(Calculator calculator, int basePrice) {
        Date productionDate = calculator.getProductionDate();
        if (isOld(productionDate)) {
            calculator.setPrice(basePrice/3);
        } else {
            if (nextState != null) {
                nextState.setPrice(calculator,basePrice);
            }
        }
    }

    private boolean isOld(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.YEAR,3);
        Date dateCopy = calendar.getTime();
        return dateCopy.compareTo(new Date()) >= 0;
    }

}
