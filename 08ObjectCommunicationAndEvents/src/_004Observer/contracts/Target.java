package _004Observer.contracts;

public interface Target {
    void receiveDamage(int dmg);
    boolean isDead();
}