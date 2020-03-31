package com.pxy.designpattern.visitor;

public class Client {
    /**
     * 使用访问者模式为企业客户和个人客户添加各种不同的行为
     */
    public static void addActionForCustomer() {
        EnterpriseCustomer enterpriseCustomer = new EnterpriseCustomer("阿里",10);
        ReportUtil.addAction(enterpriseCustomer,new BuyAction(1000));
        ReportUtil.addAction(enterpriseCustomer,new RepairAction());
        ReportUtil.report(enterpriseCustomer);

        PersonalCustomer personalCustomer = new PersonalCustomer("pxy",11);
        ReportUtil.addAction(personalCustomer,new BuyAction(2));
        ReportUtil.addAction(personalCustomer,new RepairAction());
        ReportUtil.report(personalCustomer);
    }
}
