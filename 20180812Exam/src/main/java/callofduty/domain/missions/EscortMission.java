package callofduty.domain.missions;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 12.8.2018 г.
 * Time: 09:46 ч.
 */
public class EscortMission extends BaseMission {

    public EscortMission(String id, Double rating, Double bounty) {
        super(id, rating - rating * 25D / 100D, bounty + bounty * 25D / 100D);
    }
}