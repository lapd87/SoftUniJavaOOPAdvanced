package arrpeegee.models.participants;

import arrpeegee.contracts.Hero;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 10.8.2018 г.
 * Time: 10:13 ч.
 */
public class WarriorTest {

    private Hero targetable;

    @Before
    public void setUp() {
        this.targetable = Mockito.mock(Warrior.class);
    }

    @Test
    public void isAlive() {
        Mockito.when(targetable.isAlive()).thenReturn(true);

        boolean actual = targetable.isAlive();
        boolean expected = true;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void takeDamage() {
        Mockito.when(targetable.getHealth()).thenCallRealMethod();
        Mockito.doCallRealMethod().when(targetable).setHealth(Mockito.any(Double.class));
        Mockito.doCallRealMethod().when(targetable).takeDamage(Mockito.any(Double.class));


        targetable.setHealth(100);
        targetable.takeDamage(50);

        double actual = targetable.getHealth();
        double expected = 50.0;

        Assert.assertEquals(expected, actual, 0.00000001);
    }

    @Test
    public void levelUp() {
//        this.setStrength(this.getStrength() * 2);
//        this.setDexterity(this.getDexterity() * 2);
//        this.setIntelligence(this.getIntelligence() * 2);
//        this.level += 1;
        Mockito.doCallRealMethod().when(targetable).setHealth(Mockito.any(Double.class));
        Mockito.when(targetable.getHealth()).thenCallRealMethod();

        Mockito.doCallRealMethod().when(targetable).setStrength(Mockito.any(Integer.class));
        Mockito.when(targetable.getStrength()).thenCallRealMethod();

        Mockito.doCallRealMethod().when(targetable).setDexterity(Mockito.any(Integer.class));
        Mockito.when(targetable.getDexterity()).thenCallRealMethod();

        Mockito.doCallRealMethod().when(targetable).setIntelligence(Mockito.any(Integer.class));
        Mockito.when(targetable.getIntelligence()).thenCallRealMethod();

        Mockito.doCallRealMethod().when(targetable).levelUp();

        targetable.setHealth(100);
        targetable.setStrength(10);
        targetable.setDexterity(10);
        targetable.setIntelligence(10);

        targetable.levelUp();

        int strength = targetable.getStrength();
        int dexterity = targetable.getDexterity();
        int intelligence = targetable.getIntelligence();
        double health = targetable.getHealth();

        Assert.assertEquals(20, strength, 0.00000001);
        Assert.assertEquals(20, dexterity, 0.00000001);
        Assert.assertEquals(20, intelligence, 0.00000001);
        Assert.assertEquals(200, health, 0.00000001);
    }

    @Test
    public void receiveReward() {
        Mockito.doCallRealMethod().when(targetable).receiveReward(Mockito.any(Double.class));
        Mockito.doCallRealMethod().when(targetable).getGold();

        targetable.receiveReward(100);
        double gold = targetable.getGold();

       Assert.assertEquals(100, gold, 0.00000001);
    }

    @Test
    public void giveReward() {
        Warrior winner = Mockito.mock(Warrior.class);

        Mockito.doCallRealMethod().when(targetable).giveReward(Mockito.any(Warrior.class));
        Mockito.doCallRealMethod().when(targetable).receiveReward(Mockito.any(Double.class));

        Mockito.doCallRealMethod().when(winner).giveReward(Mockito.any(Warrior.class));
        Mockito.doCallRealMethod().when(winner).receiveReward(Mockito.any(Double.class));
        Mockito.doCallRealMethod().when(winner).getGold();

        targetable.receiveReward(100);
        winner.receiveReward(50);

        targetable.giveReward(winner);

        double looserGold = targetable.getGold();
        double winnerGold = winner.getGold();


        Assert.assertEquals(0, looserGold, 0.00000001);
        Assert.assertEquals(150, winnerGold, 0.00000001);
    }
}