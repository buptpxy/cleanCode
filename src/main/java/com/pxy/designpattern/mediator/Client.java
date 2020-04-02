package com.pxy.designpattern.mediator;

public class Client {
    /**
     * 未使用中介模式时各对象间调用的方法
     */
//    public static void displayCompute() throws Exception {
//        //DisplayBox对象只需被调用，无需引用别的对象，因此可最先创建
//        DisplayBox displayBox = new DisplayBox();
//        ComputeComponent computeComponent = new ComputeComponent(displayBox);
//        //InputBox是最先发生变化的对象，它发生变化后会调用DisplayBox对象和ComputeComponent对象，
//        // 因此DisplayBox对象和ComputeComponent对象应先于InputBox对象被创建
//        // 然后在InputBox对象中把DisplayBox对象和ComputeComponent对象注入进来
//        // 而不是在InputBox对象中重新new一个DisplayBox对象和ComputeComponent对象
//        InputBox inputBox = new InputBox(displayBox);
//        inputBox.onChange("on", computeComponent);
//    }

    /**
     * 使用中介模式实现各对象间的调用
     */
    public static void displayComputeByMediator() throws Exception {
        CalculatorMediator mediator = new CalculatorMediator();
        InputBox inputBox = new InputBox(mediator);
        DisplayBox displayBox = new DisplayBox(mediator);
        ComputeComponent computeComponent = new ComputeComponent(mediator);
        mediator.setInputBox(inputBox);
        mediator.setDisplayBox(displayBox);
        mediator.setComputeComponent(computeComponent);
        inputBox.doWork("on");
    }

    public static void main(String[] args) {
        try {
            displayComputeByMediator();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
