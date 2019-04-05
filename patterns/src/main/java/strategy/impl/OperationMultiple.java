package strategy.impl;

import strategy.Strategy;

public class OperationMultiple implements Strategy {
    @Override
    public int doOperation(int a, int b) {
        return a * b;
    }
}
