package _001Lab.rpg_lab;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Dummy implements Target{

    private int health;
    private int experience;
    private List<Weapon> possibleLoot;

    public Dummy(int health, int experience) {
        this.health = health;
        this.experience = experience;
        possibleLoot=new ArrayList<Weapon>();
    }

    public int getHealth() {
        return this.health;
    }

    public void takeAttack(int attackPoints) {
        if (this.isDead()) {
            throw new IllegalStateException("Dummy is dead.");
        }

        this.health -= attackPoints;
    }

    public int giveExperience() {
        if (!this.isDead()) {
            throw new IllegalStateException("Target is not dead.");
        }

        return this.experience;
    }

    public boolean isDead() {
        return this.health <= 0;
    }

    public Weapon getPossibleLoot() {
        if (!this.isDead()) {
            throw new IllegalStateException("Target is not dead.");
        }

        return possibleLoot.get(new Random()
                .nextInt(possibleLoot.size()));
    }

    public void addPossibleLoot(Weapon weapon) {
        this.possibleLoot.add(weapon);
    }
}
