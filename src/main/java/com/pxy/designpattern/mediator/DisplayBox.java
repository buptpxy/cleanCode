package com.pxy.designpattern.mediator;

public class DisplayBox extends Component {

    public DisplayBox(Mediator mediator) {
        super(mediator);
    }

    @Override
    public String sendMessage(String message) throws Exception {
        System.out.println(message);
        return message;
    }

    @Override
    public void doWork(String message) throws Exception {
        mediator.interact(message,this);
    }

}
