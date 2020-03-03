package com.pxy.goodfunction.refactor;

import com.pxy.goodfunction.refactor.expensebasicclass.Employee;
import com.pxy.goodfunction.refactor.expensebasicclass.ExpenseReportDAO;
import com.pxy.goodfunction.refactor.expensebasicclass.MealExpenses;
import com.pxy.goodfunction.refactor.expensebasicclass.MealExpensesNotFound;

import java.util.List;

public class ExpenseReportService {
    //原代码，下面的方法要得到每天的支出，如果员工吃饭了，支出就加上员工的饭钱，如果员工没吃饭，支出就加上发放给员工的每日津贴
    //很显然异常的处理打断了正常的逻辑，不优雅
    ExpenseReportDAO expenseReportDAO = new ExpenseReportDAO();
    Employee employee = new Employee();
    public int getTotalExpense() {
        int m_total = 0;
        try {
            MealExpenses expenses = expenseReportDAO.getMeal(employee.getID());
            m_total += expenses.getTotal();
        } catch(MealExpensesNotFound e) {
            m_total += getMealPerDiem();
        }
        return m_total;
    }
    private int getMealPerDiem() {
        return 30;
    }

    //改进后的代码，通常getMeals返回MealExpensesImpl对象，如果员工没有吃饭则返回PerDiemMealExpenses对象
    //这样就无需在业务逻辑中加入异常处理，直接使用常规流程即可
    public int getPerTotalExpense() {
        int perMealTotal = 0;
        MealExpenses mealExpenses = expenseReportDAO.getMeals(employee.getID());
        perMealTotal += mealExpenses.getTotal();
        return perMealTotal;
    }


    //不让方法返回空值的例子：
    //原代码，总要先检查null值，避免空指针异常
    public int getTotalPay() {
        int totalPay = 0;
        List<Employee> employees = getEmployees();
        if (employees != null) { //因为getEmployees()方法可能返回null，所以这里要做空值检查
            for (Employee e : employees) {
                totalPay += e.getPay();
            }
        }
        return totalPay;
    }
    private List<Employee> getEmployees() {
        return employee.getEmployees();
    }

    //改进后的代码，不让employee.getAllEmployees()方法返回空，而是返回Collections.emptyList()，则无需做空值检查
    public int getTotalPays() {
        int totalPay = 0;
        List<Employee> employees = getAllEmployees();
        for (Employee employee : employees) {
            totalPay += employee.getPay();
        }
        return totalPay;
    }
    private List<Employee> getAllEmployees() {
        return employee.getAllEmployees();
    }
}
