package hell.entities.heroes;

import hell.interfaces.Inventory;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 8.8.2018 г.
 * Time: 20:51 ч.
 */
public class Assassin extends BaseHero {

    private static final long DEFAULT_STRENGTH = 25;
    private static final long DEFAULT_AGILITY = 100;
    private static final long DEFAULT_INTELLIGENCE = 15;
    private static final long DEFAULT_HIT_POINTS = 150;
    private static final long DEFAULT_DAMAGE = 300;


    public Assassin(String name, Inventory inventory) {
        super(name, DEFAULT_STRENGTH, DEFAULT_AGILITY,
                DEFAULT_INTELLIGENCE, DEFAULT_HIT_POINTS,
                DEFAULT_DAMAGE, inventory);
    }
}