package _05KingsGambitExtended.models;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 5.8.2018 г.
 * Time: 12:11 ч.
 */
public abstract class Unit {
    private String name;

    protected Unit(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
