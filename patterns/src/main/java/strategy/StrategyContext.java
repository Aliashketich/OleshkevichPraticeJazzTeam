package strategy;

class StrategyContext {
    private Strategy strategy;

    StrategyContext(Strategy strategy) {
        this.strategy = strategy;
    }

    int executeStrategy(int a, int b) {
        return strategy.doOperation(a, b);
    }
}
