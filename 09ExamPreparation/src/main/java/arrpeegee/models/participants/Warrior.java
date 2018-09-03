package arrpeegee.models.participants;

import arrpeegee.contracts.Hero;
import arrpeegee.contracts.Targetable;
import arrpeegee.models.Config;

public class Warrior implements Hero {

    private int strength;
    private int dexterity;
    private int intelligence;
    int level;

    private double health;
    private String name;
    boolean isAlive;
    double gold;

    public Warrior() {
        this.isAlive = true;
        this.level = 1;
        this.gold = Config.HERO_START_GOLD;
        this.setStrength(Config.WARRIOR_BASE_STRENGTH);
        this.setDexterity(Config.WARRIOR_BASE_DEXTERITY);
        this.setIntelligence(Config.WARRIOR_BASE_INTELLIGENCE);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getStrength() {
        return strength;
    }

    @Override
    public void setStrength(int strength) {
        this.strength = strength;
        this.setHealth(strength * Config.HERO_HEALTH_MULTIPLIER);
    }

    @Override
    public int getDexterity() {
        return dexterity;
    }

    @Override
    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    @Override
    public int getIntelligence() {
        return intelligence;
    }

    @Override
    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    @Override
    public double getHealth() {
        return health;
    }

    @Override
    public void setHealth(double health) {
        this.health = health;
        if (this.health <= 0) {
            this.health = 0;
            this.isAlive = false;
        }
    }

    @Override
    public double getDamage() {
        return (this.getStrength() * 2) + this.getDexterity();
    }

    @Override
    public double getGold() {
        return this.gold;
    }

    @Override
    public boolean isAlive() {
        return this.isAlive;
    }

    @Override
    public String attack(Targetable target) {
        if (!this.isAlive()) {
            return this.getName() + " is dead! Cannot attack.";
        }

        if (!target.isAlive()) {
            return target.getName() + " is dead! Cannot be attacked.";
        }

        target.takeDamage(this.getDamage());

        String result = this.getName() + " attacked!";
        if (!target.isAlive()) {
            this.levelUp();
            target.giveReward(this);
            result += String.format(" %s has been slain by %s.",
                    target.getName(),
                    this.getName());
        }

        return result;
    }

    @Override
    public void takeDamage(double damage) {
        this.setHealth(this.getHealth() - damage);
    }

    @Override
    public void levelUp() {
        this.setStrength(this.getStrength() * 2);
        this.setDexterity(this.getDexterity() * 2);
        this.setIntelligence(this.getIntelligence() * 2);
        this.level += 1;
    }

    @Override
    public void receiveReward(double reward) {
        this.gold += reward;
    }

    @Override
    public void giveReward(Targetable targetable) {
        targetable.receiveReward(this.gold);
        this.gold = 0;
    }

//    public double getReward() {
//        this.gold = 0;
//        return this.gold;
//    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("  Name: %s | Class: %s",
                this.getName(),
                this.getClass().getSimpleName()))
                .append(System.lineSeparator())
                .append(String.format("  Health: %.2f | Damage: %.2f",
                        this.getHealth(),
                        this.getDamage()))
                .append(System.lineSeparator())
                .append(String.format("  %d STR | %d DEX | %d INT | %.2f Gold",
                        this.getStrength(),
                        this.getDexterity(),
                        this.getIntelligence(),
                        this.gold));

        return sb.toString();
    }
}
