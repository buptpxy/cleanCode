package com.pxy.designpattern.templateMethod;

public class ShowColorFactory {
    public static ShowColor newShowColorInstance(String color) throws Exception {
        switch (color) {
            case "red":
                return new ShowRed();
            case "yellow":
                return new ShowYellow();
            case "blue":
                return new ShowBlue();
            default:
                throw new Exception("颜色输入错误!");
        }
    }
}
