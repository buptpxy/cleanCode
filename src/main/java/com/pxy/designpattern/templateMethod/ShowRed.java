package com.pxy.designpattern.templateMethod;

public class ShowRed extends ShowColor {
    @Override
    protected boolean display() {
        return false;
    }
    @Override
    protected void showColor() {
        System.out.println("red!");
        System.out.println("hahaha!");
    }
}
