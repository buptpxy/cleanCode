package com.pxy.designpattern.iterator;

public abstract class Iterator {
    public abstract boolean hasNext();
    public abstract Object first() throws Exception;
    public abstract Object next() throws Exception;
}
