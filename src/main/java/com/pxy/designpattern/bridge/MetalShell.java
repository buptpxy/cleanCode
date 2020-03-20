package com.pxy.designpattern.bridge;

public class MetalShell extends Shell {
    @Override
    public void make() {
        System.out.println("Use metals make shell!");
        color.paint();
    }
}
