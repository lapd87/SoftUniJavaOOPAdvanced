package _001Lab.rpg_lab;


/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 27.7.2018 г.
 * Time: 11:51 ч.
 */
public interface Weapon {
    void attack(Target target);

    int getAttackPoints();

    int getDurabilityPoints();
}
