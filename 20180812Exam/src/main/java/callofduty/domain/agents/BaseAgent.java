package callofduty.domain.agents;


import callofduty.interfaces.Agent;
import callofduty.interfaces.Mission;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 12.8.2018 г.
 * Time: 09:37 ч.
 */
public abstract class BaseAgent implements Agent {

    private String id;
    private String name;
    private Double rating;
    private List<Mission> currentMissions;
    private long assignedMissionsCount;
    private long completedMissionsCount;

    BaseAgent(String id, String name) {
        this.id = id;
        this.name = name;
        this.rating = 0D;
        this.currentMissions = new ArrayList<>();
        this.assignedMissionsCount = 0;
        this.completedMissionsCount = 0;
    }

    BaseAgent(String id, String name, Double rating, long completedMissionsCount) {
        this(id, name);
        this.rating = rating;
        this.completedMissionsCount = completedMissionsCount;
    }

    @Override
    public void acceptMission(Mission mission) {
        this.currentMissions.add(mission);
        assignedMissionsCount++;
    }

    @Override
    public void completeMissions() {
        for (Mission currentMission : this.currentMissions) {
            this.rating += currentMission.getRating();

            if (this instanceof MasterAgent) {
                ((MasterAgent) this).increaseBounty(currentMission.getBounty());
            }

            try {
                Field field = currentMission.getClass()
                        .getSuperclass()
                        .getDeclaredField("isCompleted");
                field.setAccessible(true);
                field.set(currentMission, true);
            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        this.completedMissionsCount += this.currentMissions.size();
        this.currentMissions = new ArrayList<>();
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Double getRating() {
        return this.rating;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(String.format("%s Agent - %s",
                this.getClass().getSimpleName()
                        .replace("Agent", ""),
                this.getName()))
                .append(System.lineSeparator())
                .append(String.format("Personal Code: %s",
                        this.getId()))
                .append(System.lineSeparator())
                .append(String.format("Assigned Missions: %d",
                        this.assignedMissionsCount))
                .append(System.lineSeparator())
                .append(String.format("Completed Missions: %d",
                        this.completedMissionsCount))
                .append(System.lineSeparator())
                .append(String.format("Rating: %.2f",
                        this.getRating()));

        return stringBuilder.toString();
    }
}