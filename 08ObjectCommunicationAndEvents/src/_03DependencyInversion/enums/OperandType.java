package _03DependencyInversion.enums;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 5.8.2018 г.
 * Time: 14:13 ч.
 */
public enum OperandType {

    ADDITION("+"), SUBTRACTION("-"), DIVISION("/"), MULTIPLICATION("*");

    private String operationType;

    OperandType(String operationType) {
        this.operationType = operationType;
    }

    public String getOperandType() {
        return operationType;
    }

    @Override
    public String toString() {
        return this.name().charAt(0) + this.name().substring(1).toLowerCase();
    }
}