package com.pxy.designpattern.visitor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReportUtil {
    private static Map<Customer,List<Action>> actionMap = new HashMap<>();
    public static void addAction(Customer customer,Action action) {
        List<Action> actionList;
        if (actionMap.get(customer) == null) {
            actionList = new ArrayList<>();
            actionMap.put(customer,actionList);
        }
        actionList = actionMap.get(customer);
        actionList.add(action);
    }
    public static void removeAction(Customer customer,Action action) {
        if (actionMap.get(customer) == null) {
            return;
        }
        List<Action> actionList = actionMap.get(customer);
        actionList.remove(action);
        if (actionList.size() == 0) {
            actionMap.remove(customer);
        }
    }
    public static void report(Customer customer) {
        if (actionMap.get(customer) == null) {
            return;
        }
        List<Action> actionList = actionMap.get(customer);
        for (Action action:actionList) {
            customer.accept(action);
        }
    }
}
