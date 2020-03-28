package com.pxy.designpattern.visitor;

public class RepairAction extends Action {
    @Override
    public void priceForEnterprise(EnterpriseCustomer enterpriseCustomer) {
        System.out.println("为" + enterpriseCustomer.name + "公司修理每个计算器的价格为：" + enterpriseCustomer.unitRepairPrice() + "元");
    }

    @Override
    public void priceForPersonal(PersonalCustomer personalCustomer) {
        System.out.println(personalCustomer.name + "顾客送回坏计算器，每个退款为："+personalCustomer.unitRefund() + "元");
    }
}
