package callofduty.core;

import callofduty.interfaces.Mission;
import callofduty.interfaces.MissionControl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 12.8.2018 г.
 * Time: 13:07 ч.
 */
public class MissionControlImplTest {

    private MissionControl missionControl;


    @Before
    public void setUp() throws Exception {
        missionControl = new MissionControlImpl();

    }

    @Test
    public void testEscortMax() {
        Mission escort = missionControl.generateMission("123456789", 200D, 200000D);

        Assert.assertEquals(escort.getBounty(), 125000D, 0.00000001);
        Assert.assertEquals(escort.getRating(), 75D, 0.00000001);
        Assert.assertEquals(escort.getId(), "12345678");
        Assert.assertEquals(escort.getClass().getSimpleName(), "EscortMission");
    }

    @Test
    public void testHuntMax() {
        Mission escort = missionControl.generateMission("123456789", 200D, 200000D);
        Mission hunt = missionControl.generateMission("123456789", 200D, 200000D);

        Assert.assertEquals(hunt.getBounty(), 200000D, 0.00000001);
        Assert.assertEquals(hunt.getRating(), 150D, 0.00000001);
        Assert.assertEquals(hunt.getId(), "12345678");
        Assert.assertEquals(hunt.getClass().getSimpleName(), "HuntMission");
    }

    @Test
    public void testSurveillanceMax() {
        Mission escort = missionControl.generateMission("123456789", 200D, 200000D);
        Mission hunt = missionControl.generateMission("123456789", 200D, 200000D);
        Mission surveillance = missionControl.generateMission("123456789", 200D, 200000D);

        Assert.assertEquals(surveillance.getBounty(), 150000D, 0.00000001);
        Assert.assertEquals(surveillance.getRating(), 25D, 0.00000001);
        Assert.assertEquals(surveillance.getId(), "12345678");
        Assert.assertEquals(surveillance.getClass().getSimpleName(), "SurveillanceMission");
    }

    @Test
    public void testEscortMin() {
        Mission escort = missionControl.generateMission("123456789", -200D, -200000D);

        Assert.assertEquals(escort.getBounty(), 0, 0.00000001);
        Assert.assertEquals(escort.getRating(), 0, 0.00000001);
    }

    @Test
    public void testHuntMin() {
        Mission escort = missionControl.generateMission("0123456789", 200D, 200000D);
        Mission hunt = missionControl.generateMission("123456789", -200D, -200000D);

        Assert.assertEquals(hunt.getBounty(), 0, 0.00000001);
        Assert.assertEquals(hunt.getRating(), 0, 0.00000001);
    }

    @Test
    public void testSurveillanceMin() {
        Mission escort = missionControl.generateMission("0123456789", 200D, 200000D);
        Mission hunt = missionControl.generateMission("1023456789", 200D, 200000D);
        Mission surveillance = missionControl.generateMission("123456789", -200D, -200000D);

        Assert.assertEquals(surveillance.getBounty(), 0, 0.00000001);
        Assert.assertEquals(surveillance.getRating(), 0, 0.00000001);
    }

    @Test
    public void testIterator() {
        Mission escort = missionControl.generateMission("0123456789", 200D, 200000D);
        Mission hunt = missionControl.generateMission("1023456789", 200D, 200000D);
        Mission surveillance = missionControl.generateMission("123456789", -200D, -200000D);
        Mission escort2 = missionControl.generateMission("1203456789", -200D, -200000D);

        Assert.assertEquals(escort.getClass().getSimpleName(), escort2.getClass().getSimpleName());
    }
}