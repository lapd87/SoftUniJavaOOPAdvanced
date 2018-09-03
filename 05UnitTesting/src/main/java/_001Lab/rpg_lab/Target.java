package _001Lab.rpg_lab;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 27.7.2018 г.
 * Time: 11:52 ч.
 */
public interface Target {
    void takeAttack(int attackPoints);

    int getHealth();

    int giveExperience();

    boolean isDead();

    Weapon getPossibleLoot();

    void addPossibleLoot(Weapon weapon);
}
