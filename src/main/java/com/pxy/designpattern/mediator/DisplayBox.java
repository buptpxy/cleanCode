package com.pxy.designpattern.mediator;

public class DisplayBox extends Component {

    public DisplayBox(Mediator mediator) {
        super(mediator);
    }

    @Override
    public String sendMessage(String message) {
        System.out.println("输出框显示："+message);
        return message;
    }

    @Override
    public void doWork(String message) {

    }

}
