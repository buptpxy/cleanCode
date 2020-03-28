package com.pxy.designpattern.visitor;

public class BuyAction extends Action {
    private int count;
    public BuyAction(int count) {
        this.count = count;
    }
    @Override
    public void priceForEnterprise(EnterpriseCustomer enterpriseCustomer) {
        System.out.println(enterpriseCustomer.name + "公司购买了" + count + "个计算器");
        System.out.println("单价为："+ enterpriseCustomer.getUnitPrice(count) + "元");
        System.out.println("总价为："+ enterpriseCustomer.getTotalPrice(count) + "元");
    }

    @Override
    public void priceForPersonal(PersonalCustomer personalCustomer) {
        System.out.println(personalCustomer.name + "顾客购买了" + count + "个计算器");
        System.out.println("单价为："+ personalCustomer.getUnitPrice(count) + "元");
        System.out.println("总价为："+ personalCustomer.getTotalPrice(count) + "元");
    }
}
