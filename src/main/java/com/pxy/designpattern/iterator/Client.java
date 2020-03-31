package com.pxy.designpattern.iterator;

public class Client {
    /**
     * 使用迭代器模式遍历数组栈
     */
    public static void showByIterator() throws Exception {
        ConcreteAggregate intStack = new ConcreteAggregate(5);
        for (int i = 0; i < intStack.getCapacity(); i++) {
            intStack.push(i);
        }
        Iterator stackIterator = intStack.createIterator();
        while (stackIterator.hasNext()) {
            System.out.println(stackIterator.next());
        }
    }
}
