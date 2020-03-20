package com.pxy.designpattern.bridge;

public class PlasticShell extends Shell {
    @Override
    public void make() {
        System.out.println("Use plastics make shell!");
        color.paint();
    }
}
