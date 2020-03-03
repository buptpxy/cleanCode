package com.pxy.goodfunction.refactor.expensebasicclass;

import java.util.Collections;
import java.util.List;

public class Employee {
    public int getID() {
        return 1;
    }

    public int getMealExpense() {
        return 1;
    }

    public int getPay() {
        return 1;
    }

    public List<Employee> getEmployees() {
        return null;
    }

    public List<Employee> getAllEmployees() {
        return Collections.emptyList();
    }
}
