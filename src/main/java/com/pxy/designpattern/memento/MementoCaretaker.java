package com.pxy.designpattern.memento;

import java.util.Stack;

public class MementoCaretaker {

    private Stack<Memento> mementoStack = new Stack<>();

    public Memento getMemento() {
        return mementoStack.pop();
    }

    public  void setMemento(Memento memento) {
        mementoStack.push(memento);
    }
}
