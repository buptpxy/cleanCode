package com.pxy.designpattern.mediator;

public abstract class Mediator {
    public abstract void interact(String message,Component component) throws Exception;
}
