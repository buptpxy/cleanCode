package com.pxy.designpattern.decorator;

public class ShowBlack extends ShowColor {
    @Override
    protected void showColor() {
        System.out.println("Black!");
    }

}
