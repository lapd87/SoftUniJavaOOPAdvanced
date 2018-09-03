package _003CoffeeMachine;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 18.7.2018 г.
 * Time: 09:53 ч.
 */
public enum CoffeeType {

    ESPRESSO, LATTE, IRISH;

    @Override
    public String toString() {
        return this.name().charAt(0)
                + this.name().substring(1).toLowerCase();
    }
}
