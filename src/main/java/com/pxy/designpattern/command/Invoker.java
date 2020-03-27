package com.pxy.designpattern.command;

import java.util.*;

public class Invoker {

    Map<String, List<Command>> commandMap = new HashMap<>();
    public void addCommand(String userName,Command command) {
        List<Command> commandList = commandMap.get(userName);
        if (commandList == null) {
            commandList = new ArrayList<>();
        }
        commandList.add(command);
    }

    public void cancelCommand(String userName,Command command) throws Exception {
        List<Command> commandList = commandMap.get(userName);
        if (commandList == null || commandList.isEmpty()) {
            throw new Exception("没有命令可以取消了！");
        }
        commandList.remove(command);
    }

    public void executeCommands(String userName) throws Exception {
        List<Command> commandList = commandMap.get(userName);
        if (commandList == null || commandList.isEmpty()) {
            throw new Exception("没有命令可以执行了！");
        }
        for (Command command:commandList) {
            command.executeCommand();
            Iterator iterator = commandList.iterator();
            iterator.next();
        }
    }
}
