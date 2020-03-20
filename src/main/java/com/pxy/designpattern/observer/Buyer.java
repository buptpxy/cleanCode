package com.pxy.designpattern.observer;

public class Buyer {
    public void buy(int price) {
        if (price <= 10) {
            System.out.println("OMG！买它！");
        }
    }
}
