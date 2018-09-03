package callofduty.domain.missions;

import callofduty.interfaces.Mission;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 12.8.2018 г.
 * Time: 09:44 ч.
 */
public abstract class BaseMission implements Mission {

    private String id;
    private Double rating;
    private Double bounty;
    private boolean isCompleted;

    BaseMission(String id, Double rating, Double bounty) {
        this.id = id;
        this.rating = rating;
        this.bounty = bounty;
        this.isCompleted = false;
    }

    private String getStatus() {
        if (this.isCompleted) {
            return "Completed";
        } else {
            return "Open";
        }
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public Double getBounty() {
        return this.bounty;
    }

    @Override
    public Double getRating() {
        return this.rating;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(String.format("%s Mission - %s",
                this.getClass().getSimpleName()
                        .replace("Mission", ""),
                this.getId()))
                .append(System.lineSeparator())
                .append(String.format("Status: %s",
                        this.getStatus()))
                .append(System.lineSeparator())
                .append(String.format("Rating: %.2f",
                        this.getRating()))
                .append(System.lineSeparator())
                .append(String.format("Bounty: %.2f",
                        this.getBounty()));

        return stringBuilder.toString();
    }
}