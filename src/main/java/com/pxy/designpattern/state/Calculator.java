package com.pxy.designpattern.state;

import java.util.Calendar;
import java.util.Date;

public class Calculator {
    private Date productionDate;
    private int price;
    private State state;
    private ProductState productState;

    public Calculator() {
        state = new NewProductState();
    }

    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }

    public void setPriceByState(int basePrice) {
        state.setPrice(this, basePrice);
    }

    public Date getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(Date productionDate) {
        this.productionDate = productionDate;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public ProductState getProductState() {
        return this.productState;
    }

    public void setProductState() {
        Calendar oldTime = Calendar.getInstance();
        oldTime.setTime(productionDate);
        oldTime.add(Calendar.YEAR,1);//生产1年后
        Date turnOldDate = oldTime.getTime();

        Calendar deadTime = Calendar.getInstance();
        deadTime.setTime(productionDate);
        deadTime.add(Calendar.YEAR,3);//生产3年后
        Date turnDeadDate = deadTime.getTime();

        Date now = new Date();
        if (now.compareTo(turnOldDate) <= 0) {//判断状态
            productState = ProductState.NEW;
        }else if (now.compareTo(turnDeadDate) <= 0) {
            productState = ProductState.OLD;
        }else {
            productState = ProductState.DEAD;
        }
    }
}