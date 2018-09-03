package _03DependencyInversion.models.strategies;

import _03DependencyInversion.annotations.CalculationMode;
import _03DependencyInversion.contracts.Strategy;

@CalculationMode("-")
public class SubtractionStrategy implements Strategy {
    @Override
    public int calculate(int firstOperand, int secondOperand) {
        return firstOperand - secondOperand;
    }
}
