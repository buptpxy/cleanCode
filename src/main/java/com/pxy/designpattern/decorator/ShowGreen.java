package com.pxy.designpattern.decorator;

public class ShowGreen extends ShowColor {
    @Override
    protected void showColor() {
        System.out.println("Blue!");
    }

}
