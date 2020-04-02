package com.pxy.designpattern.templateMethod;

public class ShowBlack extends ShowColor {
    @Override
    protected void showColor() {
        System.out.println("Black!");
    }

}
