package _02KingsGambit.contracts;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 5.8.2018 г.
 * Time: 12:11 ч.
 */
public interface Killable {
    void die();

    boolean isKilled();

    void handleAttack();
}
