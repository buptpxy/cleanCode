package com.pxy.designpattern.visitor;

public abstract class Action {
    public abstract void priceForEnterprise(EnterpriseCustomer enterpriseCustomer);
    public abstract void priceForPersonal(PersonalCustomer personalCustomer);
}
