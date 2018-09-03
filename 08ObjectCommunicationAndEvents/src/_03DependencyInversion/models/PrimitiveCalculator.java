package _03DependencyInversion.models;


import _03DependencyInversion.contracts.Strategy;
import _03DependencyInversion.models.strategies.AdditionStrategy;

public class PrimitiveCalculator {

    private Strategy strategy;

    public PrimitiveCalculator() {
        this.strategy = new AdditionStrategy();
    }

    public void changeStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public int performCalculation(int firstOperand, int secondOperand) {
        return this.strategy
                .calculate(firstOperand, secondOperand);
    }
}
