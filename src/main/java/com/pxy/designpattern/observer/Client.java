package com.pxy.designpattern.observer;

public class Client {
    /**
     * 使用观察者模式来通知买方和卖方买入或卖掉计算器
     */
    public void NotifyObserver(Calculator calculator) {
        int price = calculator.getPrice();
        Buyer buyer = new Buyer();
        Seller seller = new Seller();
        Event buyEvent = buyer::buy;
        Event sellEvent = seller::sell;
        EventHandler.addEvent(buyEvent);
        EventHandler.addEvent(sellEvent);
        EventHandler.Notify(price);
    }
}
