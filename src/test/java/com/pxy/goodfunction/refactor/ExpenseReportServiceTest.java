package com.pxy.goodfunction.refactor;

import org.junit.Assert;
import org.junit.Test;

public class ExpenseReportServiceTest {
    @Test
    public void testGetTotalPay() {
        ExpenseReportService expenseReportService = new ExpenseReportService();
        Assert.assertEquals(0,expenseReportService.getTotalPay());
    }
}
