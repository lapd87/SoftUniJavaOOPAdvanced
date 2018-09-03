package callofduty.core;

import callofduty.domain.agents.MasterAgent;
import callofduty.domain.agents.NoviceAgent;
import callofduty.interfaces.*;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 12.8.2018 г.
 * Time: 10:21 ч.
 */
public class MissionManagerImpl implements MissionManager {

    private Map<String, Agent> agents;
    private Map<String, Mission> missions;
    private MissionControl missionControl;

    public MissionManagerImpl(MissionControl missionControl) {
        this.agents = new HashMap<>();
        this.missions = new HashMap<>();
        this.missionControl = missionControl;
    }

    @Override
    public String agent(List<String> arguments) {

        String id = arguments.get(1);
        String name = arguments.get(2);

        Agent agent = new NoviceAgent(id, name);

        this.agents.putIfAbsent(id, agent);

        return String.format("Registered Agent - %s:%s",
                name, id);
    }

    @Override
    public String request(List<String> arguments) {

        String agentId = arguments.get(1);
        String missionId = arguments.get(2);
        Double rating = Double.valueOf(arguments.get(3));
        Double bounty = Double.valueOf(arguments.get(4));

        Mission mission = this.missionControl
                .generateMission(missionId, rating, bounty);

        Agent agent = this.agents.get(agentId);

        agent.acceptMission(mission);

        this.missions.putIfAbsent(missionId, mission);

        return String.format("Assigned %s Mission - %s to Agent - %s",
                mission.getClass().getSimpleName()
                        .replace("Mission", ""),
                missionId,
                agent.getName());
    }

    @Override
    public String complete(List<String> arguments) {

        String agentId = arguments.get(1);

        Agent agent = agents.get(agentId);

        agent.completeMissions();

        Class agentClass = agent.getClass();

        if ("NoviceAgent".equals(agentClass.getSimpleName())) {
            try {
                Field field = agentClass.getSuperclass()
                        .getDeclaredField("completedMissionsCount");
                field.setAccessible(true);

                long completedMissionsCount = field.getLong(agent);

                if (completedMissionsCount >= 3) {
                    Agent masterAgent = new MasterAgent(agentId,
                            agent.getName(),
                            agent.getRating(),
                            completedMissionsCount);

                    this.agents.put(agentId, masterAgent);
                }
            } catch (NoSuchFieldException
                    | IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        return String.format("Agent - %s:%s has completed all assigned missions.",
                agent.getName(), agentId);
    }

    @Override
    public String status(List<String> arguments) {

        String id = arguments.get(1);

        for (Map.Entry<String, Agent> agentEntry : agents.entrySet()) {
            if (agentEntry.getKey().equals(id)) {
                return agentEntry.getValue().toString();
            }
        }

        for (Map.Entry<String, Mission> missionEntry : missions.entrySet()) {
            if (missionEntry.getKey().equals(id)) {
                return missionEntry.getValue().toString();
            }
        }

        return null;
    }

    @Override
    public String over(List<String> arguments) {

        List<MasterAgent> masterAgents = this.agents.values()
                .stream()
                .filter(a -> "MasterAgent"
                        .equals(a.getClass().getSimpleName()))
                .map(a -> (MasterAgent) a)
                .collect(Collectors.toList());

        long noviceAgentsCount = this.agents.size() - masterAgents.size();

        long masterAgentsCount = masterAgents.size();

        long assignedMissionsCount = this.missions.size();

        long completedMissionsCount = this.missions.values()
                .stream()
                .filter(m -> {
                    try {
                        Field field = m.getClass().getSuperclass()
                                .getDeclaredField("isCompleted");
                        field.setAccessible(true);
                        return field.getBoolean(m);
                    } catch (NoSuchFieldException | IllegalAccessException e) {
                        e.printStackTrace();
                        return false;
                    }
                })
                .count();

        Double totalRatingEarned = this.agents.values()
                .stream()
                .mapToDouble(Rateable::getRating)
                .sum();

        Double totalBountyEarned = masterAgents.stream()
                .mapToDouble(MasterAgent::getBounty)
                .sum();

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(String.format("Novice Agents: %d",
                noviceAgentsCount))
                .append(System.lineSeparator())
                .append(String.format("Master Agents: %d",
                        masterAgentsCount))
                .append(System.lineSeparator())
                .append(String.format("Assigned Missions: %d",
                        assignedMissionsCount))
                .append(System.lineSeparator())
                .append(String.format("Completed Missions: %d",
                        completedMissionsCount))
                .append(System.lineSeparator())
                .append(String.format("Total Rating Given: %.2f",
                        totalRatingEarned))
                .append(System.lineSeparator())
                .append(String.format("Total Bounty Given: $%.2f",
                        totalBountyEarned));

        return stringBuilder.toString();
    }
}