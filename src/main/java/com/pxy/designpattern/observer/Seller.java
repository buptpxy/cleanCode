package com.pxy.designpattern.observer;

public class Seller {
    public void sell(int price) {
        if (price >= 10) {
            System.out.println("OMG！价格为"+price+"元了，卖掉！");
        }
    }
}
