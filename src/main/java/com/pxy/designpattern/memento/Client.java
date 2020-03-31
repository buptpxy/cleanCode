package com.pxy.designpattern.memento;

public class Client {
    /**
     * 使用备忘录模式记录计算器的价格和状态
     */
    public void backupByMemento() {
        MementoCaretaker mementoCaretaker = new MementoCaretaker();
        Calculator calculator = new Calculator();
        //第一次更改状态和价格后备份
        calculator.setState(new NewProductState());
        calculator.setPrice(10);
        mementoCaretaker.setMemento(calculator.backup());
        //第二次更改状态和价格后备份
        calculator.setState(new OldProductState());
        calculator.setPrice(9);
        mementoCaretaker.setMemento(calculator.backup());
        //第三次更改状态和价格后备份
        calculator.setState(new DeadProductState());
        calculator.setPrice(8);
        mementoCaretaker.setMemento(calculator.backup());

        System.out.println(calculator.getPrice());//现在是8

        calculator.recover(mementoCaretaker.getMemento());//恢复备份
        System.out.println(calculator.getPrice());//现在是9

        calculator.recover(mementoCaretaker.getMemento());//恢复备份
        System.out.println(calculator.getPrice());//现在是10
    }
}
