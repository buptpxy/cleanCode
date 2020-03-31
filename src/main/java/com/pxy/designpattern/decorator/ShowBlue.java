package com.pxy.designpattern.decorator;

public class ShowBlue extends ShowColor {
    @Override
    protected void showColor() {
        System.out.println("Blue!");
    }
}
