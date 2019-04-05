package strategy;

import exception.MyException;
import strategy.impl.OperationAdd;
import strategy.impl.OperationDivision;
import strategy.impl.OperationMultiple;
import strategy.impl.OperationSubtract;

class StrategySelection {
    int selectOperationStrategy(int a, int b, String command) throws MyException, NullPointerException, ArithmeticException {
        StrategyContext strategyContext;
        switch (command) {
            case "add":
                strategyContext = new StrategyContext(new OperationAdd());
                return strategyContext.executeStrategy(a, b);
            case "subtract":
                strategyContext = new StrategyContext(new OperationSubtract());
                return strategyContext.executeStrategy(a, b);
            case "multiple":
                strategyContext = new StrategyContext(new OperationMultiple());
                return strategyContext.executeStrategy(a, b);
            case "division":
                strategyContext = new StrategyContext(new OperationDivision());
                return strategyContext.executeStrategy(a, b);
            default:
                throw new MyException("Have not that strategy!");
        }
    }
}
