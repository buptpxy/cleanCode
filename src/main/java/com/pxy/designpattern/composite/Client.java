package com.pxy.designpattern.composite;

public class Client {
    /**
     * 使用组合模式管理修理和卖计算器的店铺
     */
    public static void manageByComposite() {
        CalculatorShop headShop = new ConcreteShop("总店");
        CalculatorShop headRepairDesk = new RepairDesk("总店修理计算器柜台");
        CalculatorShop headSellDesk = new SellDesk("总店卖计算器柜台");
        headShop.addChildren(headRepairDesk);
        headShop.addChildren(headSellDesk);

        CalculatorShop beijingShop = new ConcreteShop("北京分店");
        CalculatorShop bjRepairDesk = new RepairDesk("北京分店修理计算器柜台");
        CalculatorShop bjSellDesk = new SellDesk("北京分店卖计算器柜台");
        headShop.addChildren(beijingShop);
        beijingShop.addChildren(bjRepairDesk);
        beijingShop.addChildren(bjSellDesk);

        CalculatorShop haidianShop = new ConcreteShop("海淀区分店");
        CalculatorShop hdRepairDesk = new RepairDesk("海淀区分店修理计算器柜台");
        CalculatorShop hdSellDesk = new SellDesk("海淀区分店卖计算器柜台");
        beijingShop.addChildren(haidianShop);
        haidianShop.addChildren(hdRepairDesk);
        haidianShop.addChildren(hdSellDesk);

        System.out.println("计算器店铺结构图：");
        headShop.display(1);

        System.out.println("计算器店铺主营业务：");
        headShop.doBusiness();
    }

    public static void main(String[] args) {
        manageByComposite();
    }
}
