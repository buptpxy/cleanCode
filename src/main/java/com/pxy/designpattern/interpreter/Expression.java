package com.pxy.designpattern.interpreter;

import java.util.Map;

public abstract class Expression {
    //用map是因为要把先传入的公式中的字母与后传入的数字参数对应起来
    //interpret负责对对传递进来的参数和值进行解析和匹配，其中输入参数为HashMap类型，key值为模型中的参数，如a、b、c等，value为运算时取得的具体数字。
    public abstract int interpret(Map<String,Integer> expressionMap);
}
