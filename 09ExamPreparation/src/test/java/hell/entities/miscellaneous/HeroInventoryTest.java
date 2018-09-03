package hell.entities.miscellaneous;

import hell.interfaces.Inventory;
import hell.interfaces.Item;
import hell.interfaces.Recipe;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 8.8.2018 г.
 * Time: 20:05 ч.
 */
public class HeroInventoryTest {

    private static final int INT_MAX_VALUE = Integer.MAX_VALUE;

    private Inventory inventory;

    @Before
    public void setUp() {
        this.inventory = new HeroInventory();

        for (int i = 1; i <= 3; i++) {
            this.inventory.addCommonItem(seedCommonItem(i));
        }
    }

    private Recipe seedRecipeItem() {
        Recipe recipe = Mockito.mock(Recipe.class);
        List<String> items = new ArrayList<String>() {{
            add("item1");
            add("item2");
            add("item4");
        }};
        Mockito.when(recipe.getRequiredItems()).thenReturn(items);

        return recipe;
    }

    private Item seedCommonItem(int index) {
        Item item = Mockito.mock(Item.class, "item" + index);
        Mockito.when(item.getName()).thenReturn("item" + index);
        Mockito.when(item.getStrengthBonus()).thenReturn(INT_MAX_VALUE);
        Mockito.when(item.getAgilityBonus()).thenReturn(INT_MAX_VALUE);
        Mockito.when(item.getIntelligenceBonus()).thenReturn(INT_MAX_VALUE);
        Mockito.when(item.getHitPointsBonus()).thenReturn(INT_MAX_VALUE);
        Mockito.when(item.getDamageBonus()).thenReturn(INT_MAX_VALUE);

        return item;
    }

    @Test
    public void getTotalStrengthBonus() {
        long totalBonus = this.inventory.getTotalStrengthBonus();

        long expected = 3L * INT_MAX_VALUE;

        Assert.assertEquals(expected, totalBonus);
    }

    @Test
    public void getTotalAgilityBonus() {
        long totalBonus = this.inventory.getTotalAgilityBonus();

        long expected = 3L * INT_MAX_VALUE;

        Assert.assertEquals(expected, totalBonus);
    }

    @Test
    public void getTotalIntelligenceBonus() {
        long totalBonus = this.inventory.getTotalIntelligenceBonus();

        long expected = 3L * INT_MAX_VALUE;

        Assert.assertEquals(expected, totalBonus);
    }

    @Test
    public void getTotalHitPointsBonus() {
        long totalBonus = this.inventory.getTotalHitPointsBonus();

        long expected = 3L * INT_MAX_VALUE;

        Assert.assertEquals(expected, totalBonus);
    }

    @Test
    public void getTotalDamageBonus() {
        long totalBonus = this.inventory.getTotalDamageBonus();

        long expected = 3L * INT_MAX_VALUE;

        Assert.assertEquals(expected, totalBonus);
    }

    @Test
    public void addCommonItem() {
        try {
            Field commonItems = this.inventory.getClass().getDeclaredField("commonItems");
            commonItems.setAccessible(true);
            Map<String, Item> initialItems = (Map<String, Item>) commonItems.get(this.inventory);
            int initialSize = initialItems.size();

            this.inventory.addRecipeItem(seedRecipeItem());

            this.inventory.addCommonItem(seedCommonItem(4));

            Map<String, Item> afterAddItems = (Map<String, Item>) commonItems.get(this.inventory);
            int afterAddSize = afterAddItems.size();


            Assert.assertEquals(initialSize - 1, afterAddSize);

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void addRecipeItem() {
        try {
            Field recipeItems = this.inventory.getClass().getDeclaredField("recipeItems");
            recipeItems.setAccessible(true);
            Map<String, Recipe> initialItems = (Map<String, Recipe>) recipeItems.get(this.inventory);
            int initialSize = initialItems.size();

            this.inventory.addRecipeItem(seedRecipeItem());

            Map<String, Recipe> afterAddItems = (Map<String, Recipe>) recipeItems.get(this.inventory);
            int afterAddSize = afterAddItems.size();


            Assert.assertEquals(initialSize + 1, afterAddSize);

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}