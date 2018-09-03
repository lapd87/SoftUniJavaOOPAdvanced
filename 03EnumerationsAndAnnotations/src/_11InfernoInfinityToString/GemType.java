package _11InfernoInfinityToString;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 19.7.2018 г.
 * Time: 08:31 ч.
 */
public enum GemType {

    RUBY(7, 2, 5), EMERALD(1, 4, 9), AMETHYST(2, 8, 4);

    private int strengthBonus;
    private int agilityBonus;
    private int vitalityBonus;

    GemType(int strengthBonus, int agilityBonus, int vitalityBonus) {
        this.strengthBonus = strengthBonus;
        this.agilityBonus = agilityBonus;
        this.vitalityBonus = vitalityBonus;
    }

    public int getStrengthBonus() {
        return strengthBonus;
    }

    public int getAgilityBonus() {
        return agilityBonus;
    }

    public int getVitalityBonus() {
        return vitalityBonus;
    }
}