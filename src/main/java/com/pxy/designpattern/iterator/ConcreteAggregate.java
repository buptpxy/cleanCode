package com.pxy.designpattern.iterator;

public class ConcreteAggregate extends Aggregate{
    private Integer[] intStack;
    private int capacity;
    private int size = 0;

    public int getCapacity() {
        return capacity;
    }

    public int getSize() {
        return size;
    }

    public ConcreteAggregate(int capacity) {
        this.capacity = capacity;
        intStack = new Integer[capacity];
    }
    @Override
    public Iterator createIterator() {
        return new ConcreteIterator(this);
    }
    public void push(int num) throws Exception {
        if (size < capacity) {
            intStack[size++] = num;
        }else {
            throw new Exception("栈已满！");
        }
    }
    public int pop() throws Exception {
        if (size > 0) {
            return intStack[--size];
        }else {
            throw new Exception("栈已空！");
        }
    }
    public int current(int index) throws Exception {
        if (size > 0 && index < size) {
            return intStack[index];
        }else if (size == 0){
            throw new Exception("栈为空！");
        }else {
            throw new Exception("索引越界！");
        }
    }
}
