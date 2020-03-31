package com.pxy.designpattern.builder;

public class Calculator implements Cloneable {
    private Chip chip;
    private Keyboard keyboard;
    private Screen screen;
    private Shell shell;

    public Calculator() {
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

}