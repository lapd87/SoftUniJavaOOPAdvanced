package callofduty.domain.agents;

import callofduty.interfaces.BountyAgent;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 12.8.2018 г.
 * Time: 09:40 ч.
 */
public class MasterAgent extends BaseAgent implements BountyAgent {

    private Double bounty;

    public MasterAgent(String id, String name, Double rating, long completedMissionsCount) {
        super(id, name, rating, completedMissionsCount);
        this.bounty = 0D;
    }

    void increaseBounty(Double bounty) {
        this.bounty += bounty;
    }

    @Override
    public Double getBounty() {
        return this.bounty;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(super.toString())
                .append(System.lineSeparator())
                .append(String.format("Bounty Earned: $%.2f",
                        this.getBounty()));

        return stringBuilder.toString();
    }
}