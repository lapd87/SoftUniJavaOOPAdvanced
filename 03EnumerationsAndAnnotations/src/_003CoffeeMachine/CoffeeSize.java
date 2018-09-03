package _003CoffeeMachine;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 18.7.2018 г.
 * Time: 10:05 ч.
 */
public enum CoffeeSize {

    SMALL(50, 50), NORMAL(100, 75), DOUBLE(200, 100);

    private int volumeML;
    private int price;

    CoffeeSize(int volumeML, int price) {
        this.volumeML = volumeML;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return this.name().charAt(0)
                + this.name().substring(1).toLowerCase();
    }
}