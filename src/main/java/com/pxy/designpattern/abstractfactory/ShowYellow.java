package com.pxy.designpattern.abstractfactory;

public class ShowYellow extends ShowColor {
    @Override
    protected void showColor() {
        System.out.println("yellow!");
    }
}
