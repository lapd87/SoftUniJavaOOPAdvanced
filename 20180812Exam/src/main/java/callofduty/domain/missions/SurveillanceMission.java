package callofduty.domain.missions;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 12.8.2018 г.
 * Time: 09:46 ч.
 */
public class SurveillanceMission extends BaseMission {

    public SurveillanceMission(String id, Double rating, Double bounty) {
        super(id,
                rating - rating * 75D / 100D,
                bounty + bounty * 50D / 100D);
    }
}