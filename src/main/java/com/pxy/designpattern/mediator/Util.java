package com.pxy.designpattern.mediator;

public class Util {
    public static boolean isNumber(String str) {
        if (str == null || str.trim().equals("")) {
            return false;
        }
        for (char chr: str.toCharArray()) {
            if (chr < '0' || chr > '9') {
                return false;
            }
        }
        return true;
    }

    public static int stringToInt(String str) throws Exception {
        if (str == null || str.trim().equals("")) {
            throw new Exception("空字符串无法被转换为数字！");
        }
        return Integer.parseInt(str);
    }

}
