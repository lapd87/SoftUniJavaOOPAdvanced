package hell.entities.items;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 8.8.2018 г.
 * Time: 20:58 ч.
 */
public class CommonItem extends BaseItem {

    public CommonItem(String name, int strengthBonus,
                         int agilityBonus, int intelligenceBonus,
                         int hitPointsBonus, int damageBonus) {
        super(name, strengthBonus, agilityBonus,
                intelligenceBonus, hitPointsBonus, damageBonus);
    }
}