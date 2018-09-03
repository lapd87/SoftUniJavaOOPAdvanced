package _03DependencyInversion.contracts;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 5.8.2018 г.
 * Time: 12:47 ч.
 */
public interface Strategy {

    int calculate(int firstOperand, int secondOperand);
}
