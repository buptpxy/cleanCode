package com.pxy.designpattern.observer;

public class Buyer {
    public void buy(int price) {
        if (price <= 10) {
            System.out.println("OMG！价格为" + price +"元了，买它！");
        }
    }
}
