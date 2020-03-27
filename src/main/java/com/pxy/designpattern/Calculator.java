package com.pxy.designpattern;

import com.pxy.designpattern.adapter.SlightlyOldStateAdapter;
import com.pxy.designpattern.builder.BlackCalculatorBuilder;
import com.pxy.designpattern.builder.BuilderDirector;
import com.pxy.designpattern.builder.CalculatorBuilder;
import com.pxy.designpattern.builder.RedCalculatorBuilder;
import com.pxy.designpattern.decorator.ShowColor;
import com.pxy.designpattern.decorator.ShowColorFactory;
import com.pxy.designpattern.memento.MementoCaretaker;
import com.pxy.designpattern.memento.Memento;
import com.pxy.designpattern.observer.Buyer;
import com.pxy.designpattern.observer.Event;
import com.pxy.designpattern.observer.EventHandler;
import com.pxy.designpattern.observer.Seller;
import com.pxy.designpattern.facade.*;
import com.pxy.designpattern.factorymethod.*;
import com.pxy.designpattern.prototype.Brand;
import com.pxy.designpattern.proxy.OperationContextProxy;
import com.pxy.designpattern.simplefactory.Operation;
import com.pxy.designpattern.simplefactory.OperationFactory;
import com.pxy.designpattern.state.*;
import com.pxy.designpattern.strategy.OperationContext;
import com.pxy.designpattern.strategy.OperationContextImpl;

import java.util.*;

public class Calculator implements Cloneable {
    private Chip chip;
    private Keyboard keyboard;
    private Screen screen;
    private Shell shell;
    private Brand brand;
    private String type;
    private String color;
    private Calendar productionDate;
    private int price;
    private State state;
    private ProductState productState;

    public Calculator() {
        state = new NewProductState();
        chip = new Chip();
        keyboard = new Keyboard();
        screen = new Screen();
        shell = new Shell();
        brand = new Brand();
    }

    public Chip getChip() {
        return chip;
    }

    public void setChip(Chip chip) {
        this.chip = chip;
    }

    public Keyboard getKeyboard() {
        return keyboard;
    }

    public void setKeyboard(Keyboard keyboard) {
        this.keyboard = keyboard;
    }

    public Screen getScreen() {
        return screen;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    public Shell getShell() {
        return shell;
    }

    public void setShell(Shell shell) {
        this.shell = shell;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public int getPrice() {
        return price;
    }

    //    public void setPrice(int price) {
//        this.price = price;
//    }
    public void setPrice(int basePrice) {
        state.setPrice(this, basePrice);
    }

    public String getBrandName() {
        return brand.getName();
    }

    public void setBrandName(String name) {
        brand.setName(name);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Calendar getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(Calendar productionDate) {
        this.productionDate = productionDate;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Calculator clone() throws CloneNotSupportedException {
        return (Calculator) super.clone();
    }

    public Calculator deepClone() throws CloneNotSupportedException {
        Calculator calculatorCopy = (Calculator) super.clone();
        calculatorCopy.brand = brand.deepClone();
        return calculatorCopy;
    }

    public Memento backup() {
        return new Memento(state, price);
    }

    public void recover(Memento memento) {
        state = memento.getState();
        price = memento.getPrice();
    }

    public ProductState getProductState() {
        return productState;
    }

    public void setProductState(ProductState productState) {
        this.productState = productState;
    }

    public void packageChip() {
        System.out.println("A chip has packaged!");
    }
    public void packageKeyboard() {
        System.out.println("A keyboard has packaged!");
    }
    public void packageScreen(){
        System.out.println("A screen has packaged!");
    };
    public void packageShell() {
        System.out.println("A red shell has packaged!");
    }

    public int compute(int num1, String operator, int num2) throws Exception {
        switch (operator) {
            case "+":
                return num1+num2;
            case "-":
                return num1-num2;
            case "*":
                return num1*num2;
            case "/":
                if (num2 == 0) {
                    throw new Exception("除数不能为0");
                } else {
                    return num1/num2;
                }
            default:
                throw new Exception("运算符输入错误!");
        }
    }

    public int computeByStrategy(int num1, String operator, int num2) throws Exception {
        OperationContext operationContext = new OperationContextImpl();
        return operationContext.execute(num1,operator,num2);
    }
}