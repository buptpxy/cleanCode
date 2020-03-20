package com.pxy.designpattern.adapter;

import com.pxy.designpattern.Calculator;
import com.pxy.designpattern.state.State;

public class SlightlyOldStateAdapter extends State {
    private SlightlyOldState slightlyOldState = new SlightlyOldState();
    @Override
    public void setPrice(Calculator calculator, int basePrice) {
        slightlyOldState.changePrice(calculator,basePrice);
    }

    @Override
    protected void changeState(Calculator calculator) {
        slightlyOldState.changeState(calculator);
    }
}