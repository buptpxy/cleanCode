package com.pxy.designpattern.decorator;

public class ShowYellow extends ShowColor {
    @Override
    protected void showColor() {
        System.out.println("yellow!");
    }
}
