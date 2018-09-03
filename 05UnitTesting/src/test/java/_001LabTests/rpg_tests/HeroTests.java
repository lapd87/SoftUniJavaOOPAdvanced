package _001LabTests.rpg_tests;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import _001Lab.rpg_lab.Hero;
import _001Lab.rpg_lab.Target;
import _001Lab.rpg_lab.Weapon;

import java.util.Collection;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 27.7.2018 г.
 * Time: 11:56 ч.
 */
public class HeroTests {

    private static final int TARGET_XP = 10;
    private static final int AXE_ATTACK = 10;
    private static final int AXE_DURABILITY = 0;
    private static final int INVENTORY_SIZE = 1;
    private static final String HERO_NAME = "hero";

    @Test
    public void attackGainsXPIfTargerIsDead() {
        Target fakeTarget = new Target() {
            public void takeAttack(int attackPoints) {

            }

            public int getHealth() {
                return 0;
            }

            public int giveExperience() {
                return TARGET_XP;
            }

            public boolean isDead() {
                return true;
            }

            public Weapon getPossibleLoot() {
                return null;
            }

            public void addPossibleLoot(Weapon weapon) {

            }
        };

        Weapon fakeWeapon = new Weapon() {
            public void attack(Target target) {

            }

            public int getAttackPoints() {
                return AXE_ATTACK;
            }

            public int getDurabilityPoints() {
                return AXE_DURABILITY;
            }
        };

        Hero hero = new Hero(HERO_NAME, fakeWeapon);

        hero.attack(fakeTarget);

        Assert.assertEquals("Wrong XP",
                TARGET_XP,
                hero.getExperience());
    }

    @Test
    public void attackGainsXPIfTargerIsDead2() {
        Weapon weaponMock = Mockito.mock(Weapon.class);
        Target targetMock = Mockito.mock(Target.class);

        Mockito.when(targetMock.isDead()).thenReturn(true);
        Mockito.when(targetMock.giveExperience()).thenReturn(TARGET_XP);

        Hero hero = new Hero(HERO_NAME, weaponMock);

        hero.attack(targetMock);

        Assert.assertEquals("Wrong XP2",
                TARGET_XP,
                hero.getExperience());
    }

    @Test
    public void getLootFromAliveTarget() {
        Weapon weaponMock = Mockito.mock(Weapon.class);
        Weapon weaponMock2 = Mockito.mock(Weapon.class);

        Target targetMock = Mockito.mock(Target.class);

        targetMock.addPossibleLoot(weaponMock2);

        Mockito.when(targetMock.isDead()).thenReturn(true);

        Hero hero = new Hero(HERO_NAME, weaponMock);

        hero.attack(targetMock);

        Assert.assertEquals(INVENTORY_SIZE,
                ((Collection<?>) hero.getInventory()).size());
    }
}