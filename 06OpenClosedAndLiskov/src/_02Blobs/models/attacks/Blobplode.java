package _02Blobs.models.attacks;

import _02Blobs.models.Blob;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 2.8.2018 г.
 * Time: 13:57 ч.
 */
public class Blobplode extends AbstractAttack {

    private static final int BLOBPLODE_DAMAGE_MULTIPLY = 2;

    @Override
    public void execute(Blob attacker, Blob target) {
        int attackerHealthAfter = attacker.getHealth()
                - attacker.getHealth() / 2;

        if (attackerHealthAfter >= 1) {
            attacker.setHealth(attackerHealthAfter);
        }

        target.setHealth(target.getHealth()
                - attacker.getDamage() * BLOBPLODE_DAMAGE_MULTIPLY);
    }
}