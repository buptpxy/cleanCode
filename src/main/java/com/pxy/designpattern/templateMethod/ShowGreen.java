package com.pxy.designpattern.templateMethod;

public class ShowGreen extends ShowColor {
    @Override
    protected void showColor() {
        System.out.println("Blue!");
    }

}
