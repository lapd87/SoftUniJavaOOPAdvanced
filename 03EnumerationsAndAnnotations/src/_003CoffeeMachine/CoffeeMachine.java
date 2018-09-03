package _003CoffeeMachine;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 18.7.2018 г.
 * Time: 10:06 ч.
 */
public class CoffeeMachine {

    private List<Coffee> coffeesSold;
    private int money;

    public CoffeeMachine() {
        this.coffeesSold = new ArrayList<>();
        this.money = 0;
    }

    public void insertCoin(String coin) {
        this.money += Enum.valueOf(Coin.class, coin)
                .getCoinValue();
    }

    public void buyCoffee(String size, String type) {
        Coffee coffee = new Coffee(size, type);

        if (coffee.getPrice() <= money) {
            money = 0;
            coffeesSold.add(coffee);
        }
    }

    public Iterable<Coffee> coffeesSold() {
        return this.coffeesSold;
    }
}