package arrpeegee.models.actions;

import arrpeegee.contracts.Action;
import arrpeegee.contracts.Targetable;
import arrpeegee.models.participants.Warrior;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 10.8.2018 г.
 * Time: 10:21 ч.
 */
public class OneVsOneTest {

    private Action action;
    private List<Targetable> participants;

    @Before
    public void setUp() {

        this.action = Mockito.mock(OneVsOne.class);

        this.participants = new ArrayList<>();

        for (int i = 0; i < 2; i++) {
            addTargetable(i);
        }
    }

    private void addTargetable(int i) {
        Warrior mock = Mockito.mock(Warrior.class, "name" + i);
        this.participants.add(mock);
    }

    @Test
    public void executeAction() {
        addTargetable(3);

        Mockito.doCallRealMethod().when(action).executeAction(Mockito.any(List.class));


        String actual = action.executeAction(participants);
        String expected = "There should be exactly 2 participants for OneVsOne!";

        Assert.assertEquals(expected, actual);
    }
}