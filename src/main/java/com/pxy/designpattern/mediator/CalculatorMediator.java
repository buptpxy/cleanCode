package com.pxy.designpattern.mediator;

public class CalculatorMediator extends Mediator{
    private InputBox inputBox;
    private DisplayBox displayBox;
    private ComputeComponent computeComponent;
    //这三个方法由客户端来调用
    public void setComputeComponent(ComputeComponent computeComponent) {
        this.computeComponent = computeComponent;
    }

    public void setInputBox(InputBox inputBox) {
        this.inputBox = inputBox;
    }

    public void setDisplayBox(DisplayBox displayBox) {
        this.displayBox = displayBox;
    }

    @Override
    public void interact(String message,Component component) throws Exception {
        if (component == inputBox) {
            if (message.equals("off")) {
                return;
            }
            displayBox.sendMessage(message);
            while (inputBox.turnOn) {
                message = inputBox.sendMessage(message);
                message = computeComponent.sendMessage(message);
                displayBox.sendMessage(message);
                if (computeComponent.turnOff) {
                    inputBox.sendMessage("off");
                }
            }
        }else {
            //由于这个例子的调用是有严格的先后顺序的，只能先输入再计算、显示，所以无论传入的component是哪个，都应先调用inputBox
            interact(message,inputBox);
        }
    }
}
