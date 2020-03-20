package com.pxy.designpattern;

import com.pxy.designpattern.adapter.SlightlyOldStateAdapter;
import com.pxy.designpattern.builder.BlackCalculatorBuilder;
import com.pxy.designpattern.builder.BuilderDirector;
import com.pxy.designpattern.builder.CalculatorBuilder;
import com.pxy.designpattern.builder.RedCalculatorBuilder;
import com.pxy.designpattern.decorator.ShowColor;
import com.pxy.designpattern.decorator.ShowColorFactory;
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
import com.pxy.designpattern.state.DeadProductState;
import com.pxy.designpattern.state.NewProductState;
import com.pxy.designpattern.state.OldProductState;
import com.pxy.designpattern.state.State;
import com.pxy.designpattern.strategy.OperationContext;
import com.pxy.designpattern.strategy.OperationContextImpl;

import java.util.*;

public class Calculator implements Cloneable{
    private Chip chip;
    private Keyboard keyboard;
    private Screen screen;
    private Shell shell;
    private int price;
    private Brand brand = new Brand();
    private String type;
    private String color;
    private Calendar productionDate;
    private State state;


    public Calculator() {
        state = new NewProductState();
        chip = new Chip();
        keyboard = new Keyboard();
        screen = new Screen();
        shell = new Shell();
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
    public void setPrice(int basePrice) {state.setPrice(this,basePrice);}
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
        return (Calculator)super.clone();
    }
    public Calculator deepClone() throws CloneNotSupportedException {
        Calculator calculatorCopy = (Calculator)super.clone();
        calculatorCopy.brand = brand.deepClone();
        return calculatorCopy;
    }

    /**
     * 下面的函数实现了一个简易计算器，可实现加减乘除操作
     * 这个方法的缺点有：
     * 低可维护性、可扩展性：如果要增加其他运算形式需改现有逻辑，运算种类和运算逻辑耦合性较强
     * 低可复用性，代码只针对一种特殊场景，不能用于其他类似场景
     * 应使用面向对象的思维，重新实现一个计算器，使得修改其中一个运算逻辑无需知道其他运算逻辑的代码
     */
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

    /**
     * 使用工厂模式的计算器，可方便的扩展其他操作运算，而无需更改已有操作运算的实现逻辑
     * 对任意一个操作类型的更改也不会影响其他操作
     */
    public static int computeByFactory(int num1, String operator, int num2) throws Exception {
        Operation operation = OperationFactory.createOperation(operator);
        return operation.operate(num1,num2);
    }

    /**
     * 客户端无需知道操作类对象和操作运算的实现，操作运算的实现与操作的调用完全解耦
     */
    public int computeByStrategy(int num1, String operator, int num2) throws Exception {
        OperationContext operationContext = new OperationContextImpl();
        return operationContext.execute(num1,operator,num2);
    }

    /**
     * 给计算器计算结果的时候增加打印颜色的功能，使用装饰模式。这样无论要打印多少种颜色和按何种顺序打印，都可由参数colors指定，也不影响原来的计算功能
     */
    public int computeByDecorator(int num1, String operator, int num2, String[] colors) throws Exception {
        Calculator calculator = new Calculator();
        ShowColor showColor = ShowColorFactory.newShowColorInstance(colors[0]);
        showColor.setCalculator(calculator);
        for (int i = 1; i < colors.length; i++) {
            ShowColor showColorI = ShowColorFactory.newShowColorInstance(colors[i]);
            showColorI.setCalculator(showColor);
            showColor = showColorI;
        }
        return showColor.computeByStrategy(num1,operator,num2);
    }

    /**
     * 要知道指定暗号才能使用运算功能
     */
    public int computeByProxy(int num1, String operator, int num2) throws Exception {
        OperationContext operationContextProxy = new OperationContextProxy("芝麻开门");
        return operationContextProxy.execute(num1,operator,num2);
    }

    /**
     * 增加新操作类型时增加对应的工厂类即可，无需更改原有工厂类代码。
     * 但对工厂类型的使用判断放到客户端中了，增加了客户端的复杂度。且每新增一种操作就要新增两个类，代码量增加较多。
     * 所以只在实例化对象的逻辑比较复杂、新增新的操作类型的需求较频繁时，才推荐使用工厂方法模式
     */
    public int computeByFactoryMethod(int num1, String operator, int num2) throws Exception {
        OperateFactory operateFactory;
        switch (operator) {
            case "+":
                operateFactory = new SumFactory();
                break;
            case "-":
                operateFactory = new SubFactory();
                break;
            case "*":
                operateFactory = new MulFactory();
                break;
            case "/":
                operateFactory = new DivFactory();
                break;
            case "%":
                operateFactory = new ModFactory();
                break;
            default:
                throw new Exception("运算符输入错误!");
        }
        Operation operation = operateFactory.newOperationInstance();
        return operation.operate(num1,num2);
    }

    /**
     * 抽象工厂模式实现一系列有关联的方法的调用
     */
    public int computeByAbstractFactory(int num1, String operator, int num2) throws Exception {
        OperateFactory operateFactory;
        switch (operator) {
            case "+":
                operateFactory = new SumFactory();
                break;
            case "-":
                operateFactory = new SubFactory();
                break;
            case "*":
                operateFactory = new MulFactory();
                break;
            case "/":
                operateFactory = new DivFactory();
                break;
            case "%":
                operateFactory = new ModFactory();
                break;
            default:
                throw new Exception("运算符输入错误!");
        }
        ShowColor showColor = operateFactory.newShowColorInstance();
        showColor.setCalculator(new Calculator());
        return showColor.computeByStrategy(num1,operator,num2);
    }

    public List<Calculator> generateThreeCalculators() {
        List<Calculator> calculators = new ArrayList<>();
        Calendar productionDate = Calendar.getInstance();
        Calculator calculator1 = new Calculator();
        calculator1.setPrice(10);
        calculator1.setBrandName("卡西欧");
        calculator1.setColor("黑色");
        calculator1.setType("简单计算器");
        calculator1.setProductionDate(productionDate);
        calculators.add(calculator1);

        Calculator calculator2 = new Calculator();
        calculator2.setPrice(11);
        calculator2.setBrandName("卡西欧");
        calculator2.setColor("黑色");
        calculator2.setType("简单计算器");
        calculator2.setProductionDate(productionDate);
        calculators.add(calculator2);

        Calculator calculator3 = new Calculator();
        calculator3.setPrice(10);
        calculator3.setBrandName("卡东欧");
        calculator3.setColor("黑色");
        calculator3.setType("简单计算器");
        calculator3.setProductionDate(productionDate);
        calculators.add(calculator3);
        return calculators;
    }
    //使用原型模式拷贝计算器
    public List<Calculator> generateThreeCalculatorsByClone() throws CloneNotSupportedException {
        List<Calculator> calculators = new ArrayList<>();
        Calculator calculator1 = new Calculator();
        calculator1.setPrice(10);
        calculator1.setBrandName("卡西欧");
        calculator1.setColor("黑色");
        calculator1.setType("简单计算器");
        calculator1.setProductionDate(productionDate);
        calculators.add(calculator1);

        //由于与calculator1中不同的price字段是非引用字段，故使用浅拷贝即可
        Calculator calculator2 = calculator1.clone();
        calculator2.setPrice(11);
        calculators.add(calculator2);

        //由于与calculator1中不同的brand字段是引用字段，故需使用深拷贝
        Calculator calculator3 = calculator1.deepClone();
        calculator3.setBrandName("卡东欧");
        calculators.add(calculator3);
        return calculators;
    }

    public void packageCalculator() {
        Chip chip = new Chip();
        Keyboard keyboard = new Keyboard();
        Screen screen = new Screen();
        Shell shell = new Shell();

        System.out.println("=======正在组装一个红色的计算器=======");
        chip.packageChip();
        keyboard.packageKeyboard();
        screen.packageScreen();
        shell.packageRedShell();
        System.out.println("=======红色的计算器组装完毕=======");

        System.out.println("=======正在组装一个黑色的计算器=======");
        chip.packageChip();
        keyboard.packageKeyboard();
        screen.packageScreen();
        shell.packageBlackShell();
        System.out.println("=======黑色的计算器组装完毕=======");
    }

    /**
     * 使用外观模式组装计算器
     */
    public void packageCalculatorByFacade() throws Exception {
        CalculatorPackager calculatorPackager = new CalculatorPackager();
        calculatorPackager.packageCalculator("红");
        calculatorPackager.packageCalculator("黑");
    }

    /**
     * 使用建造者模式制造计算器
     */
    public List<Calculator> buildCalculatorByBuilder() {
        List<Calculator> calculators = new ArrayList<>();
        //制造一个红色的计算器
        CalculatorBuilder redCalculatorBuilder = new RedCalculatorBuilder();
        BuilderDirector redBuilderDirector = new BuilderDirector(redCalculatorBuilder);
        Calculator redCalculator = redBuilderDirector.buildCalculator();
        calculators.add(redCalculator);
        //制造一个黑色的计算器
        CalculatorBuilder blackCalculatorBuilder = new BlackCalculatorBuilder();
        BuilderDirector blackBuilderDirector = new BuilderDirector(blackCalculatorBuilder);
        Calculator blackCalculator = blackBuilderDirector.buildCalculator();
        calculators.add(blackCalculator);

        return calculators;
    }

    /**
     * 根据时间改变计算器的价格
     */
    public void setPriceByTime(Calculator calculator) {
        int basePrice = 10;
        Calendar productionDate = calculator.getProductionDate();
        Calendar turnOldDate = (Calendar) productionDate.clone();
        Calendar turnDeadDate = (Calendar) productionDate.clone();
        turnOldDate.add(Calendar.YEAR,1);//生产1年后
        turnDeadDate.add(Calendar.YEAR,3);//生产3年后
        Calendar now = Calendar.getInstance();
        if (now.before(turnOldDate)) {//判断状态
            calculator.setPrice(basePrice); //对应的业务逻辑
        }else if (now.before(turnDeadDate)) {
            calculator.setPrice(basePrice/2);
        }else {
            calculator.setPrice(basePrice/10);
        }
    }

    /**
     * 把状态改变的逻辑抽象出来
     */
    private enum ProductState {
        NEW,
        OLD,
        DEAD
    }

    private ProductState productState;

    public ProductState getProductState() {
        return productState;
    }

    public void setProductState(ProductState productState) {
        this.productState = productState;
    }

    private void setProductStateValue(Calculator calculator) {
        Calendar productionDate = calculator.getProductionDate();
        Calendar turnOldDate = (Calendar) productionDate.clone();
        Calendar turnDeadDate = (Calendar) productionDate.clone();
        turnOldDate.add(Calendar.YEAR,1);//生产1年后
        turnDeadDate.add(Calendar.YEAR,3);//生产3年后
        Calendar now = Calendar.getInstance();
        if (now.before(turnOldDate)) {//判断状态
            calculator.setProductState(ProductState.NEW);
        }else if (now.before(turnDeadDate)) {
            calculator.setProductState(ProductState.OLD);
        }else {
            calculator.setProductState(ProductState.DEAD);
        }
    }

    public void setPriceByProductState(Calculator calculator) {
        int basePrice = 10;
        if (calculator.getProductState() == ProductState.NEW) {
            calculator.setPrice(basePrice);
        }else if (calculator.getProductState() == ProductState.OLD) {
            calculator.setPrice(basePrice/2);
        }else if (calculator.getProductState() == ProductState.DEAD) {
            calculator.setPrice(basePrice/10);
        }else {
            calculator.setPrice(0);
        }
    }

    /**
     * 使用状态模式来设置计算器的价格，使用适配器模式增加SlightlyOld状态，客户端代码不变，状态的变化流程写死在具体的State类中
     */
    public void setPriceByState(Calculator calculator) {
        int basePrice = 10;
        calculator.setPrice(basePrice);
    }
    /**
     * 使用观察者模式来通知买方和卖方买入或卖掉计算器
     */
    public void NotifyObserver(Calculator calculator) {
        int price = calculator.getPrice();
        Buyer buyer = new Buyer();
        Seller seller = new Seller();
        Event buyEvent = buyer::buy;
        Event sellEvent = seller::sell;
        EventHandler.addEvent(buyEvent);
        EventHandler.addEvent(sellEvent);
        EventHandler.Notify(price);
    }
    /**
     * 使用职责链模式来设置计算器的价格，在客户端来配置状态的变化流程
     */
    public void setPriceByResponsibility(Calculator calculator) {
        int basePrice = 10;
        State newState = new NewProductState();
        State slightlyOldState = new SlightlyOldStateAdapter();
        State oldState = new OldProductState();
        State deadState = new DeadProductState();
        newState.setNextState(slightlyOldState);
        slightlyOldState.setNextState(oldState);
        oldState.setNextState(deadState);

        calculator.setState(newState);
        calculator.setPrice(basePrice);
    }
}
