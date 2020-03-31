package com.pxy.designpattern.abstractfactory;

public class ShowGreen extends ShowColor {
    @Override
    protected void showColor() {
        System.out.println("Blue!");
    }

}
