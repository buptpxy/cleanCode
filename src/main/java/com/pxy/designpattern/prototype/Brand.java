package com.pxy.designpattern.prototype;

public class Brand implements Cloneable{
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public Brand deepClone() throws CloneNotSupportedException {
        return (Brand) super.clone();
    }

}
