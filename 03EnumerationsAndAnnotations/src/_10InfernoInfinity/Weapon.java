package _10InfernoInfinity;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 19.7.2018 г.
 * Time: 08:33 ч.
 */
public class Weapon {

    private WeaponType type;
    private String name;
    private GemType[] gems;
    private int minDamage;
    private int maxDamage;
    private int strength;
    private int agility;
    private int vitality;

    public Weapon(String type, String name) {
        this.type = WeaponType.valueOf(type.toUpperCase());
        this.name = name;
        this.gems = new GemType[this.type.getSocketsCount()];
        this.minDamage = this.type.getMinDamage();
        this.maxDamage = this.type.getMaxDamage();
        this.strength = 0;
        this.agility = 0;
        this.vitality = 0;
    }

    public void addGem(int index, String gem) {
        if (index >= 0
                && index < gems.length) {

            if (gems[index] != null) {
                removeGem(index);
            }

            GemType gemType = GemType.valueOf(gem.toUpperCase());
            gems[index] = gemType;

            int strengthBonus = gemType.getStrengthBonus();
            this.minDamage += strengthBonus * 2;
            this.maxDamage += strengthBonus * 3;
            this.strength += strengthBonus;

            int agilityBonus = gemType.getAgilityBonus();
            this.minDamage += agilityBonus;
            this.maxDamage += agilityBonus * 4;
            this.agility += agilityBonus;

            this.vitality += gemType.getVitalityBonus();
        }
    }

    public void removeGem(int index) {
        if (index >= 0
                && index < gems.length
                && gems[index] != null) {

            GemType gemType = gems[index];
            gems[index] = null;

            int strengthBonus = gemType.getStrengthBonus();
            this.minDamage -= strengthBonus * 2;
            this.maxDamage -= strengthBonus * 3;
            this.strength -= strengthBonus;

            int agilityBonus = gemType.getAgilityBonus();
            this.minDamage -= agilityBonus;
            this.maxDamage -= agilityBonus * 4;
            this.agility -= agilityBonus;

            this.vitality -= gemType.getVitalityBonus();
        }
    }

    @Override
    public String toString() {
        return String.format("%s: %d-%d Damage, +%d Strength, +%d Agility, +%d Vitality",
                name,
                minDamage,
                maxDamage,
                strength,
                agility,
                vitality);
    }
}