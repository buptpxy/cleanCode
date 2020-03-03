package com.pxy.goodfunction.refactor.expensebasicclass;

public class ExpenseReportDAO {
    Employee employee;
    public MealExpenses getMeal(int id) throws MealExpensesNotFound {
        int mealExpense = employee.getMealExpense();
        if (mealExpense == 0) {
            throw new MealExpensesNotFound();
        }
        return new MealExpensesImpl(id);
    }
    public MealExpenses getMeals(int id) {
        int mealExpense = employee.getMealExpense();
        if (mealExpense == 0) {
            return new PerDiemMealExpenses(id);
        }
        return new MealExpensesImpl(id);
    }
}
