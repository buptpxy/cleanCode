package com.pxy.designpattern.mediator;

public abstract class Component {
    protected Mediator mediator;
    public Component(Mediator mediator) {
        this.mediator = mediator;
    }
    public abstract String sendMessage(String message) throws Exception;
    public abstract void doWork(String message) throws Exception;
}
