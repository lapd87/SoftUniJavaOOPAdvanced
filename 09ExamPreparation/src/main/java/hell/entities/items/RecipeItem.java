package hell.entities.items;

import hell.interfaces.Recipe;

import java.util.Collections;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 8.8.2018 г.
 * Time: 20:58 ч.
 */
public class RecipeItem extends BaseItem implements Recipe {

    private List<String> requiredItems;

    public RecipeItem(String name, int strengthBonus,
                         int agilityBonus, int intelligenceBonus,
                         int hitPointsBonus, int damageBonus,
                         List<String> requiredItems) {
        super(name, strengthBonus, agilityBonus,
                intelligenceBonus, hitPointsBonus, damageBonus);
        this.requiredItems = requiredItems;
    }

    @Override
    public List<String> getRequiredItems() {
        return Collections.unmodifiableList(requiredItems);
    }
}