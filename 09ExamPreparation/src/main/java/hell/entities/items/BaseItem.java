package hell.entities.items;

import hell.interfaces.Item;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 8.8.2018 г.
 * Time: 20:54 ч.
 */
public abstract class BaseItem implements Item {

    private String name;
    private int strengthBonus;
    private int agilityBonus;
    private int intelligenceBonus;
    private int hitPointsBonus;
    private int damageBonus;

    protected BaseItem(String name, int strengthBonus,
                       int agilityBonus, int intelligenceBonus,
                       int hitPointsBonus, int damageBonus) {
        this.name = name;
        this.strengthBonus = strengthBonus;
        this.agilityBonus = agilityBonus;
        this.intelligenceBonus = intelligenceBonus;
        this.hitPointsBonus = hitPointsBonus;
        this.damageBonus = damageBonus;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getStrengthBonus() {
        return this.strengthBonus;
    }

    @Override
    public int getAgilityBonus() {
        return this.agilityBonus;
    }

    @Override
    public int getIntelligenceBonus() {
        return this.intelligenceBonus;
    }

    @Override
    public int getHitPointsBonus() {
        return this.hitPointsBonus;
    }

    @Override
    public int getDamageBonus() {
        return this.damageBonus;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(String.format("###Item: %s",
                name))
                .append(System.lineSeparator())
                .append(String.format("###+%d Strength",
                        strengthBonus))
                .append(System.lineSeparator())
                .append(String.format("###+%d Agility",
                        agilityBonus))
                .append(System.lineSeparator())
                .append(String.format("###+%d Intelligence",
                        intelligenceBonus))
                .append(System.lineSeparator())
                .append(String.format("###+%d HitPoints",
                        hitPointsBonus))
                .append(System.lineSeparator())
                .append(String.format("###+%d Damage",
                        damageBonus));

        return stringBuilder.toString().trim();
    }
}