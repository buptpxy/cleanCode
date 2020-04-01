package com.pxy.designpattern.responsibility;

public class SlightlyOldStateAdapter extends State {
    private SlightlyOldState slightlyOldState = new SlightlyOldState();
    public void setNextState(State nextState) {
        slightlyOldState.setNextState(nextState);
    }
    @Override
    public void setPrice(Calculator calculator, int basePrice) {
        slightlyOldState.changePrice(calculator,basePrice);
    }
}
