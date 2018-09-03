package hell.entities.heroes;

import hell.interfaces.Inventory;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 8.8.2018 г.
 * Time: 20:51 ч.
 */
public class Barbarian extends BaseHero {

    private static final long DEFAULT_STRENGTH = 90;
    private static final long DEFAULT_AGILITY = 25;
    private static final long DEFAULT_INTELLIGENCE = 10;
    private static final long DEFAULT_HIT_POINTS = 350;
    private static final long DEFAULT_DAMAGE = 150;


    public Barbarian(String name, Inventory inventory) {
        super(name, DEFAULT_STRENGTH, DEFAULT_AGILITY,
                DEFAULT_INTELLIGENCE, DEFAULT_HIT_POINTS,
                DEFAULT_DAMAGE, inventory);
    }
}