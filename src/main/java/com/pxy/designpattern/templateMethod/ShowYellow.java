package com.pxy.designpattern.templateMethod;

public class ShowYellow extends ShowColor {
    @Override
    protected void showColor() {
        System.out.println("yellow!");
    }
}
