package com.pxy.designpattern.iterator;
//实现从栈顶到栈底遍历
public class ConcreteIterator extends Iterator {
    private ConcreteAggregate concreteAggregate;
    private int cursor;
    public ConcreteIterator(ConcreteAggregate concreteAggregate) {
        this.concreteAggregate = concreteAggregate;
        cursor = concreteAggregate.getSize();
    }
    @Override
    public boolean hasNext() {
        return cursor > 0;
    }

    @Override
    public Object first() throws Exception {
        cursor = concreteAggregate.getSize() - 1;
        return concreteAggregate.current(cursor);
    }

    @Override
    public Object next() throws Exception {
        return concreteAggregate.current(--cursor);
    }

}
