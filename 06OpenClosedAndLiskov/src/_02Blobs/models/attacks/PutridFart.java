package _02Blobs.models.attacks;


import _02Blobs.models.Blob;

public class PutridFart extends AbstractAttack {

    @Override
    public void execute(Blob attacker, Blob target) {
        int currentHealth = target.getHealth();
        currentHealth -= attacker.getDamage();
        target.setHealth(currentHealth);
    }
}
