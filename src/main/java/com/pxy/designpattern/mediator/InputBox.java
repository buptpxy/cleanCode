package com.pxy.designpattern.mediator;

import java.util.Scanner;

public class InputBox extends Component {
    public Scanner scanner;
    public boolean turnOn = true;

    public InputBox(Mediator mediator) {
        super(mediator);
        scanner = new Scanner(System.in);
    }

    @Override
    public String sendMessage(String message) throws Exception {
        if (message.equals("on")) {
            turnOn = true;
        }else if (message.equals("off")) {
            scanner.close();
            turnOn = false;
            return message;
        }
        System.out.print("输入框输入：");
        return scanner.next();
    }

    @Override
    public void doWork(String message) throws Exception {
        mediator.interact(message,this);
    }
}
