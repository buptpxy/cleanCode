package com.pxy.designpattern.bridge;

public class Client {
    public static void makeShell() {
        Color red = new RedColor();
        Color green = new GreenColor();

        Shell plasticShell = new PlasticShell();
        plasticShell.setColor(red);
        plasticShell.make();
        plasticShell.setColor(green);
        plasticShell.make();

        Shell metalShell= new MetalShell();
        metalShell.setColor(red);
        metalShell.make();
        metalShell.setColor(green);
        metalShell.make();
    }

    public static void main(String[] args) {
        makeShell();
    }
}
