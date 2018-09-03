package hell.entities.heroes;

import hell.entities.miscellaneous.ItemCollection;
import hell.interfaces.Hero;
import hell.interfaces.Inventory;
import hell.interfaces.Item;
import hell.interfaces.Recipe;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 8.8.2018 г.
 * Time: 20:41 ч.
 */
public abstract class BaseHero implements Hero {

    private String name;
    private long strength;
    private long agility;
    private long intelligence;
    private long hitPoints;
    private long damage;
    private Inventory inventory;

    protected BaseHero(String name, long strength,
                       long agility, long intelligence,
                       long hitPoints, long damage,
                       Inventory inventory) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
        this.hitPoints = hitPoints;
        this.damage = damage;
        this.inventory = inventory;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public long getStrength() {
        return this.strength
                + inventory.getTotalStrengthBonus();
    }

    @Override
    public long getAgility() {
        return this.agility
                + inventory.getTotalAgilityBonus();
    }

    @Override
    public long getIntelligence() {
        return this.intelligence
                + inventory.getTotalIntelligenceBonus();
    }

    @Override
    public long getHitPoints() {
        return this.hitPoints
                + inventory.getTotalHitPointsBonus();
    }

    @Override
    public long getDamage() {
        return this.damage
                + inventory.getTotalDamageBonus();
    }

    @Override
    public Collection<Item> getItems() {

        Field[] declaredFields = this.inventory.getClass().getDeclaredFields();

        for (Field declaredField : declaredFields) {
            if (declaredField.isAnnotationPresent(ItemCollection.class)) {
                declaredField.setAccessible(true);

                try {
                    Map<String, Item> commonItems = (Map<String, Item>) declaredField.get(this.inventory);

                    return commonItems.values();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

        return null;
    }

    @Override
    public void addItem(Item item) {
        this.inventory.addCommonItem(item);
    }

    @Override
    public void addRecipe(Recipe recipe) {
        this.inventory.addRecipeItem(recipe);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        String items = getItems().size() == 0 ? " None" : System.lineSeparator()
                + getItems().stream()
                .map(Item::toString)
                .collect(Collectors.joining(System.lineSeparator()))
                .trim();

        stringBuilder.append(String.format("Hero: %s, Class: %s",
                name,
                this.getClass()
                        .getSimpleName()))
                .append(System.lineSeparator())
                .append(String.format("HitPoints: %d, Damage: %d",
                        getHitPoints(),
                        getDamage()))
                .append(System.lineSeparator())
                .append(String.format("Strength: %d",
                        getStrength()))
                .append(System.lineSeparator())
                .append(String.format("Agility: %d",
                        getAgility()))
                .append(System.lineSeparator())
                .append(String.format("Intelligence: %d",
                        getIntelligence()))
                .append(System.lineSeparator())
                .append(String.format("Items:%s",
                        items));

        return stringBuilder.toString().trim();
    }
}