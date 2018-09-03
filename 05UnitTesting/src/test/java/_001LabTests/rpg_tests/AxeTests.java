package _001LabTests.rpg_tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import _001Lab.rpg_lab.Axe;
import _001Lab.rpg_lab.Dummy;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 27.7.2018 г.
 * Time: 10:39 ч.
 */
public class AxeTests {

    private static final int AXE_ATTACK = 10;
    private static final int AXE_DURABILITY = 10;
    private static final int DUMMY_HEALTH = 10;
    private static final int DUMMY_XP = 10;
    private static final int EXPECTED_DURABILITY = AXE_DURABILITY - 1;

    private Axe axe;
    private Dummy dummy;

    @Before
    public void initializeTestObjects() {
        this.axe = new Axe(AXE_ATTACK, AXE_DURABILITY);
        this.dummy = new Dummy(DUMMY_HEALTH, DUMMY_XP);
    }

    @Test
    public void weaponAttacksLosesDurability() {
        this.axe.attack(this.dummy);

        Assert.assertEquals("Wrong durability",
                EXPECTED_DURABILITY,
                this.axe.getDurabilityPoints());
    }

    @Test(expected = IllegalStateException.class)
    public void brokenWeaponCantAttack() {
        this.axe.attack(this.dummy);
        this.axe.attack(this.dummy);
    }

}