package _003CoffeeMachine;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 18.7.2018 г.
 * Time: 10:06 ч.
 */
public class Coffee {

    private Enum size;
    private Enum type;
    private int price;

    public Coffee(String size, String type) {
        this.size = Enum.valueOf(CoffeeSize.class,
                size.toUpperCase());
        this.type = Enum.valueOf(CoffeeType.class,
                type.toUpperCase());
        this.price = Enum.valueOf(CoffeeSize.class,
                size.toUpperCase())
                .getPrice();
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return size + " " + type;
    }
}