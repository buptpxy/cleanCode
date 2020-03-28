package com.pxy.designpattern;

import com.pxy.designpattern.adapter.SlightlyOldStateAdapter;
import com.pxy.designpattern.builder.BlackCalculatorBuilder;
import com.pxy.designpattern.builder.BuilderDirector;
import com.pxy.designpattern.builder.CalculatorBuilder;
import com.pxy.designpattern.builder.RedCalculatorBuilder;
import com.pxy.designpattern.command.*;
import com.pxy.designpattern.composite.CalculatorShop;
import com.pxy.designpattern.composite.ConcreteShop;
import com.pxy.designpattern.composite.RepairDesk;
import com.pxy.designpattern.composite.SellDesk;
import com.pxy.designpattern.decorator.ShowColor;
import com.pxy.designpattern.decorator.ShowColorFactory;
import com.pxy.designpattern.facade.*;
import com.pxy.designpattern.factorymethod.*;
import com.pxy.designpattern.flyweight.*;
import com.pxy.designpattern.mediator.*;
import com.pxy.designpattern.memento.MementoCaretaker;
import com.pxy.designpattern.observer.Buyer;
import com.pxy.designpattern.observer.Event;
import com.pxy.designpattern.observer.EventHandler;
import com.pxy.designpattern.observer.Seller;
import com.pxy.designpattern.proxy.OperationContextProxy;
import com.pxy.designpattern.simplefactory.Operation;
import com.pxy.designpattern.simplefactory.OperationFactory;
import com.pxy.designpattern.state.*;
import com.pxy.designpattern.strategy.OperationContext;
import com.pxy.designpattern.strategy.OperationContextImpl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Client {
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
        Calendar productionDate = Calendar.getInstance();
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

    /**
     * 使用组合模式管理修理和卖计算器的店铺
     */
    public void manageByComposite() {
        CalculatorShop headShop = new ConcreteShop("总店");
        CalculatorShop beijingShop = new ConcreteShop("北京分店");
        CalculatorShop bjRepairDesk = new RepairDesk("北京分店修理计算器柜台");
        CalculatorShop bjSellDesk = new SellDesk("北京分店卖计算器柜台");
        headShop.addChildren(beijingShop);
        beijingShop.addChildren(bjRepairDesk);
        beijingShop.addChildren(bjSellDesk);
        CalculatorShop haidianShop = new ConcreteShop("海淀区分店");
        CalculatorShop hdRepairDesk = new RepairDesk("海淀区分店修理计算器柜台");
        CalculatorShop hdSellDesk = new SellDesk("海淀区分店卖计算器柜台");
        beijingShop.addChildren(haidianShop);
        haidianShop.addChildren(hdRepairDesk);
        haidianShop.addChildren(hdSellDesk);
        System.out.println("计算器店铺结构图：");
        headShop.display(1);
        System.out.println("计算器店铺主营业务：");
        headShop.doBusiness();
    }

    /**
     * 未使用中介模式时各对象间调用的方法
     */
//    public static void displayCompute() throws Exception {
//        //DisplayBox对象只需被调用，无需引用别的对象，因此可最先创建
//        DisplayBox displayBox = new DisplayBox();
//        ComputeComponent computeComponent = new ComputeComponent(displayBox);
//        //InputBox是最先发生变化的对象，它发生变化后会调用DisplayBox对象和ComputeComponent对象，
//        // 因此DisplayBox对象和ComputeComponent对象应先于InputBox对象被创建
//        // 然后在InputBox对象中把DisplayBox对象和ComputeComponent对象注入进来
//        // 而不是在InputBox对象中重新new一个DisplayBox对象和ComputeComponent对象
//        InputBox inputBox = new InputBox(displayBox);
//        inputBox.onChange("on", computeComponent);
//    }

    /**
     * 使用中介模式实现各对象间的调用
     */
    public static void displayComputeByMediator() throws Exception {
        CalculatorMediator mediator = new CalculatorMediator();
        InputBox inputBox = new InputBox(mediator);
        DisplayBox displayBox = new DisplayBox(mediator);
        ComputeComponent computeComponent = new ComputeComponent(mediator);
        mediator.setInputBox(inputBox);
        mediator.setDisplayBox(displayBox);
        mediator.setComputeComponent(computeComponent);
        inputBox.doWork("on");
    }

    /**
     * 使用享元模式实例化计算器对象
     */
    public static void computeByFlyweight() {
        Flyweight calculator1 = CalculatorFactory.getInstance("+");//3
        System.out.println(calculator1.operate(new ExternalNums(1,2)));
        Flyweight calculator2 = CalculatorFactory.getInstance("+");
        System.out.println(calculator2.operate(new ExternalNums(2,3))); //5
        Flyweight calculator3 = new UnSharedCalculator();
        System.out.println(calculator3.operate(new ExternalNums(3,2))); //0
        System.out.println("CalculatorFactory中的实例个数为：" + CalculatorFactory.instanceCount()); //1
    }

    public static void main(String[] args) {
        computeByFlyweight();
    }

}
