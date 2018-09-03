package _02KingsGambit.contracts;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 5.8.2018 г.
 * Time: 12:12 ч.
 */
public interface Attackable {
    void addDefender(String name, Killable defender);

    void killDefender(String name);

    void takeAttack();
}
