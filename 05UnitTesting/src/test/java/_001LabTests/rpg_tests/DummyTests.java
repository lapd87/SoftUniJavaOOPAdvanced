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
 * Time: 10:43 ч.
 */
public class DummyTests {

    private static final int AXE_ATTACK = 10;
    private static final int AXE_DURABILITY = 10;
    private static final int DUMMY_HEALTH = 10;
    private static final int DUMMY_EXTRA_HEALTH = 5;
    private static final int DUMMY_DEAD_HEALTH = 0;
    private static final int DUMMY_XP = 10;

    private Axe axe;

    @Before
    public void initializeTestObjects() {
        this.axe = new Axe(AXE_ATTACK, AXE_DURABILITY);
    }

    @Test
    public void lossesHealthWhenAttacked() {
        Dummy dummy = new Dummy(DUMMY_HEALTH + DUMMY_EXTRA_HEALTH, DUMMY_XP);

        this.axe.attack(dummy);

        Assert.assertEquals("Wrong health after attack",DUMMY_EXTRA_HEALTH, dummy.getHealth());
    }

    @Test(expected = IllegalStateException.class)
    public void deadDummyThrowsExceptionWhenAttacked() {
        Dummy dummy = new Dummy(DUMMY_DEAD_HEALTH, DUMMY_XP);

        this.axe.attack(dummy);
    }

    @Test
    public void deadDummyGivesXP() {
        Dummy dummy = new Dummy(DUMMY_DEAD_HEALTH, DUMMY_XP);

        Assert.assertEquals("Wrong dummy xp",DUMMY_XP, dummy.giveExperience());
    }

    @Test(expected = IllegalStateException.class)
    public void aliveDummyCantGiveXP() {
        Dummy dummy = new Dummy(DUMMY_HEALTH, DUMMY_XP);

        dummy.giveExperience();
    }
}