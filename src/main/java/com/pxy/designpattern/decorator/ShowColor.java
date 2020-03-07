package com.pxy.designpattern.decorator;


import com.pxy.designpattern.Computer;

public abstract class ShowColor extends Computer {
    protected Computer computer;
    public void setComputer(Computer computer) {
        this.computer = computer;
    }
    @Override
    public int computeByStrategy(int num1, String operator, int num2) throws Exception {
        if (computer != null) {
            return computer.computeByStrategy(num1, operator,num2);
        } else {
            throw new Exception("不能调用空对象的方法！");
        }
    };

}
