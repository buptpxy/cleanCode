package com.pxy.designpattern.decorator;

public class ShowBlue extends ShowColor {
    @Override
    public void showColor() {
        System.out.println("Blue!");
    }
}
