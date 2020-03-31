package com.pxy.designpattern.command;

public class Client {

    /**
     * 使用命令模式组装计算器
     */
    public void packageByCommand() throws Exception {
        Invoker invoker = new Invoker();
        Calculator calculator = new Calculator();
        Command addChipCommand = new AddChipCommand(calculator);
        Command addKeyboardCommand = new AddKeyboardCommand(calculator);
        Command addScreenCommand = new AddScreenCommand(calculator);
        Command addShellCommand = new AddShellCommand(calculator);

        invoker.addCommand("卡西欧",addScreenCommand);
        invoker.addCommand("卡西欧",addKeyboardCommand);
        invoker.addCommand("卡西欧",addShellCommand);
        invoker.cancelCommand("卡西欧",addShellCommand);
        invoker.addCommand("卡西欧",addChipCommand);
        invoker.executeCommands("卡西欧");

        invoker.addCommand("卡东欧",addChipCommand);
        invoker.addCommand("卡东欧",addChipCommand);
        invoker.addCommand("卡东欧",addScreenCommand);
        invoker.addCommand("卡东欧",addKeyboardCommand);
        invoker.addCommand("卡东欧",addShellCommand);
        invoker.executeCommands("卡东欧");
    }
}
