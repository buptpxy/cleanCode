package com.pxy.designpattern.interpreter;

import java.util.HashMap;
import java.util.Map;

import static java.lang.Character.isLetter;

public class ExpressionUtil {
    public static Map<String,Integer> genExpressionMap(String expressionStr,int[] nums) throws Exception {
        if (nums.length != (expressionStr.length()+1)/2) {
            throw new Exception("运算变量个数与参数个数不符！");
        }
        Map<String,Integer> expressionMap = new HashMap<>();
        if (expressionStr == null || expressionStr.trim().equals("")) {
            throw new Exception("公式为空！");
        }
        char[] expressionChars = expressionStr.toCharArray();
        if (!isLetter(expressionChars[0])) {
            throw new Exception("公式需以字母开头！");
        }
        int chrIndex = 0;
        int numIndex = 0;
        while (chrIndex < expressionChars.length-1) {
            char chr = expressionChars[chrIndex];
            if (isLetter(chr)) {
                if (expressionMap.containsKey(String.valueOf(chr))) {
                    throw new Exception("公式中包含了重复的变量"+chr);
                }else if (isLetter(expressionChars[chrIndex+1])) {
                    throw new Exception(chr+","+expressionChars[chrIndex+1]+"这两个变量之间需使用运算符隔开！");
                } else {
                    expressionMap.put(String.valueOf(chr),nums[numIndex++]);
                }
            }else if (!isLetter(expressionChars[chrIndex+1])){
                throw new Exception(chr+","+expressionChars[chrIndex+1]+"这两个操作符之间需使用变量隔开");
            }
            chrIndex++;
        }
        char lastChar = expressionChars[chrIndex];
        if (isLetter(lastChar)) {
            if (expressionMap.containsKey(String.valueOf(lastChar))) {
                throw new Exception("公式中包含了重复的变量" + lastChar);
            }else {
                expressionMap.put(String.valueOf(lastChar),nums[numIndex]);
            }
        }else {
            throw new Exception("公式需以字母结尾！");
        }
        return expressionMap;
    }
}
