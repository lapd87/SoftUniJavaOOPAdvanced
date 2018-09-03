package callofduty.domain.missions;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 12.8.2018 г.
 * Time: 09:46 ч.
 */
public class HuntMission extends BaseMission {

    public HuntMission(String id, Double rating, Double bounty) {
        super(id, rating + rating * 50D / 100D, bounty * 2D);
    }
}