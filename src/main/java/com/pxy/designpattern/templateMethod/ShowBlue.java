package com.pxy.designpattern.templateMethod;

public class ShowBlue extends ShowColor {
    @Override
    protected void showColor() {
        System.out.println("Blue!");
    }
}
