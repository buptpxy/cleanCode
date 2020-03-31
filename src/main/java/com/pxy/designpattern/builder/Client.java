package com.pxy.designpattern.builder;

import java.util.ArrayList;
import java.util.List;

public class Client {

    /**
     * 使用建造者模式制造计算器
     */
    public List<Calculator> buildCalculatorByBuilder() {
        List<Calculator> calculators = new ArrayList<>();
        //制造一个红色的计算器
        CalculatorBuilder redCalculatorBuilder = new RedCalculatorBuilder();
        BuilderDirector redBuilderDirector = new BuilderDirector(redCalculatorBuilder);
        Calculator redCalculator = redBuilderDirector.buildCalculator();
        calculators.add(redCalculator);
        //制造一个黑色的计算器
        CalculatorBuilder blackCalculatorBuilder = new BlackCalculatorBuilder();
        BuilderDirector blackBuilderDirector = new BuilderDirector(blackCalculatorBuilder);
        Calculator blackCalculator = blackBuilderDirector.buildCalculator();
        calculators.add(blackCalculator);

        return calculators;
    }

}
