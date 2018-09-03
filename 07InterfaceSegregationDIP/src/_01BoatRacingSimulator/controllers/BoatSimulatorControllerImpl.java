package _01BoatRacingSimulator.controllers;

import _01BoatRacingSimulator.contracts.Boat;
import _01BoatRacingSimulator.contracts.BoatSimulatorController;
import _01BoatRacingSimulator.contracts.Engine;
import _01BoatRacingSimulator.contracts.Race;
import _01BoatRacingSimulator.database.BoatSimulatorDatabase;
import _01BoatRacingSimulator.enumeration.EngineType;
import _01BoatRacingSimulator.exceptions.*;
import _01BoatRacingSimulator.models.RaceImpl;
import _01BoatRacingSimulator.models.boats.PowerBoat;
import _01BoatRacingSimulator.models.boats.RowBoat;
import _01BoatRacingSimulator.models.boats.SailBoat;
import _01BoatRacingSimulator.models.boats.Yacht;
import _01BoatRacingSimulator.models.engines.JetEngine;
import _01BoatRacingSimulator.models.engines.SterndriveEngine;
import _01BoatRacingSimulator.utility.Constants;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static _01BoatRacingSimulator.utility.Constants.*;

public class BoatSimulatorControllerImpl implements BoatSimulatorController {

    private BoatSimulatorDatabase database;
    private Map<Boat, Double> finishedBoats;
    private Map<Boat, Double> notFinishedBoats;
    private Race<Boat> currentRace;

    public BoatSimulatorControllerImpl(BoatSimulatorDatabase database) {
        this.database = database;
        this.finishedBoats = new LinkedHashMap<>();
        this.notFinishedBoats = new LinkedHashMap<>();
    }

    @Override
    public String createBoatEngine(String model,
                                   int horsepower,
                                   int displacement,
                                   String engineType)
            throws DuplicateModelException,
            NonExistantModelException {
        Engine engine;

        switch (EngineType.valueOf(engineType.toUpperCase())) {
            case JET:
                engine = new JetEngine(model, horsepower, displacement);
                break;
            case STERNDRIVE:
                engine = new SterndriveEngine(model, horsepower, displacement);
                break;
            default:
                throw new NonExistantModelException(INCORRECT_ENGINE_TYPE_MESSAGE);
        }

        this.database.getEngines().add(engine);
        return String.format(SUCCESSFUL_ENGINE_CREATION_MESSAGE,
                model,
                horsepower,
                displacement);
    }

    public String createRowBoat(String model, int weight,
                                int oars)
            throws DuplicateModelException {
        Boat rowBoat = new RowBoat(model, weight, oars);

        this.database.getBoats().add(rowBoat);
        return String.format(SUCCESSFUL_ROWBOAT_CREATION_MESSAGE,
                model);
    }

    public String createSailBoat(String model, int weight,
                                 int sailEfficiency)
            throws DuplicateModelException {
        Boat sailBoat = new SailBoat(model, weight, sailEfficiency);

        this.database.getBoats().add(sailBoat);
        return String.format(SUCCESSFUL_SAILBOAT_CREATION_MESSAGE,
                model);
    }

    public String createPowerBoat(String model, int weight,
                                  String firstEngineModel,
                                  String secondEngineModel)
            throws NonExistantModelException,
            DuplicateModelException {
        Boat powerBoat = new PowerBoat(model, weight,
                getEngineByModel(firstEngineModel),
                getEngineByModel(secondEngineModel));

        this.database.getBoats().add(powerBoat);
        return String.format(SUCCESSFUL_POWERBOAT_CREATION_MESSAGE,
                model);
    }

    public String createYacht(String model, int weight,
                              String engineModel,
                              int cargoWeight)
            throws NonExistantModelException,
            DuplicateModelException {
        Boat yachtBoat = new Yacht(model, weight,
                getEngineByModel(engineModel), cargoWeight);

        this.database.getBoats().add(yachtBoat);
        return String.format(SUCCESSFULLY_YACHT_CREATION_MESSAGE,
                model);
    }

    private Engine getEngineByModel(String engineModel)
            throws NonExistantModelException {
        return this.database.getEngines()
                .getItem(engineModel);
    }

    public String openRace(int distance, int windSpeed,
                           int oceanCurrentSpeed,
                           Boolean allowsMotorboats)
            throws RaceAlreadyExistsException {
        Race<Boat> race = new RaceImpl(distance, windSpeed,
                oceanCurrentSpeed, allowsMotorboats);

        this.validateRaceIsEmpty();

        this.currentRace = race;
        return String.format(SUCCESSFUL_RACE_CREATION_MESSAGE,
                distance, windSpeed, oceanCurrentSpeed);
    }

    public String signUpBoat(String model)
            throws NonExistantModelException,
            DuplicateModelException,
            NoSetRaceException {
        Boat boat = this.database.getBoats().getItem(model);

        this.validateRaceIsSet();

        if (!this.currentRace.getAllowsEngines()
                && !boat.isSailboat()) {
            throw new IllegalArgumentException(
                    Constants.INCORRECT_BOAT_TYPE_MESSAGE);
        }

        this.currentRace.addParticipant(boat);
        return String.format(SUCCESSFUL_BOAT_RACE_SIGNING_MESSAGE,
                model);
    }

    public String startRace()
            throws InsufficientContestantsException,
            NoSetRaceException {
        this.validateRaceIsSet();

        List<Boat> participants = this.currentRace
                .getParticipants();

        if (participants.size() < RACE_MINIMUM_BOATS_COUNT) {
            throw new InsufficientContestantsException(
                    Constants.INSUFFICIENT_CONTESTANTS_MESSAGE);
        }

        findFastest(participants);

//        this.finishedBoats = this.finishedBoats.entrySet()
//                .stream()
//                .sorted(Comparator.comparing(Map.Entry::getValue))
//                .limit(RACE_FASTEST_BOATS_COUNT)
//                .collect((Collectors.toMap(Map.Entry::getKey,
//                        Map.Entry::getValue,
//                        (oldValue, newValue) -> oldValue,
//                        LinkedHashMap::new)));

        Map<Boat, Double> raceLeaders = new LinkedHashMap<>();
        raceLeaders.putAll(this.finishedBoats);
        raceLeaders.putAll(this.notFinishedBoats);

        this.currentRace = null;
        this.finishedBoats.clear();
        this.notFinishedBoats.clear();

        int index = 0;
        StringBuilder result = new StringBuilder();
        for (Map.Entry<Boat, Double> raceLeadersEntry : raceLeaders.entrySet()) {
            result.append(String.format(RACE_FINAL_RESULTS_MESSAGE,
                    RACE_FINAL_RESULTS_PLACES_MESSAGE[index++],
                    raceLeadersEntry.getKey()
                            .getClass().getSimpleName(),
                    raceLeadersEntry.getKey()
                            .getModel(),
                    isFinished(raceLeadersEntry.getValue())))
                    .append(System.lineSeparator());
        }

        return result.toString().trim();
    }

    private void findFastest(List<Boat> participants) {
        for (Boat participant : participants) {
            Double speed = participant
                    .calculateRaceSpeed(this.currentRace);
            Double time = this.currentRace.getDistance()
                    / speed;

            if (time <= 0) {
                this.notFinishedBoats.put(participant, time);
            } else {
                this.finishedBoats.put(participant, time);
            }
        }

        this.finishedBoats = this.finishedBoats.entrySet()
                .stream()
                .sorted(Comparator.comparing(Map.Entry::getValue))
                .limit(RACE_FASTEST_BOATS_COUNT)
                .collect((Collectors.toMap(Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue,
                        LinkedHashMap::new)));

//        if (this.finishedBoats.size() >= RACE_FASTEST_BOATS_COUNT) {
//            this.notFinishedBoats.clear();
//        } else {
            this.notFinishedBoats = this.notFinishedBoats.entrySet()
                    .stream()
                    .limit(RACE_FASTEST_BOATS_COUNT - finishedBoats.size())
                    .collect((Collectors.toMap(Map.Entry::getKey,
                            Map.Entry::getValue,
                            (oldValue, newValue) -> oldValue,
                            LinkedHashMap::new)));
//        }
    }

    private String isFinished(Double time) {
        if (time <= 0) {
            return BOAT_DID_NOT_FINISH_MESSAGE;
        }
        return String.format(BOAT_FINISH_TIME_MESSAGE, time);
    }

    private void validateRaceIsSet() throws NoSetRaceException {
        if (this.currentRace == null) {
            throw new NoSetRaceException(
                    Constants.NO_SET_RACE_MESSAGE);
        }
    }

    private void validateRaceIsEmpty() throws RaceAlreadyExistsException {
        if (this.currentRace != null) {
            throw new RaceAlreadyExistsException(
                    Constants.RACE_ALREADY_EXISTS_MESSAGE);
        }
    }

    @Override
    public String getStatistic() {
        List<Boat> participants = this.currentRace
                .getParticipants();

        double countOfParticipants = participants.size();

        Map<String, List<Boat>> groupedParticipants = participants.stream()
                .collect(Collectors
                        .groupingBy((Boat boat) -> boat
                                .getClass()
                                .getSimpleName()));

        StringBuilder statistic = new StringBuilder();

        groupedParticipants.entrySet()
                .stream()
                .sorted(Comparator.comparing(Map.Entry::getKey))
                .forEach(boatsGroup -> {
                    String boatType = boatsGroup.getKey();
                    double percentage = (boatsGroup.getValue().size()
                            / countOfParticipants)
                            * 100.0;

                    statistic.append(String.format(RACE_STATISTICS_MESSAGE,
                            boatType,
                            percentage))
                            .append(System.lineSeparator());
                });

        return statistic.toString().trim();
    }
}
