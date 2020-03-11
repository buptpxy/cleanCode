package com.pxy.designpattern.decorator;

public class ShowRed extends ShowColor {
    @Override
    protected void showColor() {
        System.out.println("red!");
        System.out.println("hahaha!");
    }
}
