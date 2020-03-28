package com.pxy.designpattern.visitor;

public class PersonalCustomer extends Customer {
    public PersonalCustomer(String name, double price) {
        super(name, price);
    }

    @Override
    public void accept(Action action) {
        action.priceForPersonal(this);
    }

    public double getUnitPrice(int count) {
        if (count < 2) {
            return price;
        }else {
            return 0.98 * price;
        }
    }

    public double getTotalPrice(int count) {
        return getUnitPrice(count) * count;
    }

    public double unitRefund() {
        return price * 0.9;
    }

}
