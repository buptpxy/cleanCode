package com.pxy.designpattern.interpreter;

import java.util.Map;

public class Client {
    /**
     * 使用解释器模式实现新语言：运算公式的解析
     */
    public static int computeByInterpreter(String expressionStr,int[] nums) throws Exception {
        Map<String,Integer> expressionMap = ExpressionUtil.genExpressionMap(expressionStr,nums);
        SimpleCalculator calculator = new SimpleCalculator(expressionMap);
        return calculator.compute(expressionStr.toCharArray());
    }
}
