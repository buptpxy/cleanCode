package com.pxy.designpattern.visitor;

public class EnterpriseCustomer extends Customer {
    public EnterpriseCustomer(String name, double price) {
        super(name, price);
    }

    @Override
    public void accept(Action action) {
        action.priceForEnterprise(this);
    }

    public double getUnitPrice(int count) {
        if (count < 100) {
            return price;
        } else if (count < 200) {
            return 0.85 * price;
        } else {
            return 0.8 * price;
        }
    }

    public double getTotalPrice(int count) {
        return getUnitPrice(count) * count;
    }

    public double unitRepairPrice() {
        return price * 0.1;
    }

}
