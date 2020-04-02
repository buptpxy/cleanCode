package com.pxy.designpattern.mediator;

public class ComputeComponent extends Component {
    private Integer num1;
    private Integer num2;
    private String operation;
    public boolean turnOff = false;

    public ComputeComponent(Mediator mediator) {
        super(mediator);
    }

    //被中介者调用
    @Override
    public String sendMessage(String message) throws Exception {
        if (turnOff) {
            return "off";
        }else {
            return getDisplayValue(message);
        }
    }
    //被客户端调用
    @Override
    public void doWork(String message) {

    }

    public String getDisplayValue(String str) throws Exception {
        if (str == null || str.trim().equals("")) {
            return "输入为空！";
        }
        if (Util.isNumber(str)) {
            if (num1 == null) {
                num1 = Util.stringToInt(str);
            } else {
                num2 = Util.stringToInt(str);
            }
        } else {
            if(isCorrectOperation(str)){
                operation = str;
            } else if (str.equals("=")) {
                if (num1 == null || num2 == null) {
                    return "至少有一个运算数字为空！";
                }
                if (operation == null) {
                    return "运算符为空！";
                }
                return compute();
            } else {
                return "运算符错误！";
            }
        }
        return str;
    }

    private String compute(){
        int result = 0;
        switch (operation) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    return "除数为0！";
                }
                break;
            default:
                break;
        }
        reset();
        return String.valueOf(result);
    }

    private boolean isCorrectOperation(String str) {
        return str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/");
    }

    //在正确进行完一次计算后，将本对象的状态清空，并关闭InputBox的输入流
    private void reset() {
        num1 = null;
        num2 = null;
        operation = null;
        turnOff = true;
    }

}
