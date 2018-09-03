package _01BoatRacingSimulator.models.boats;

import _01BoatRacingSimulator.contracts.Boat;
import _01BoatRacingSimulator.contracts.Race;
import _01BoatRacingSimulator.utility.Constants;
import _01BoatRacingSimulator.utility.Validator;

public abstract class BaseBoat implements Boat {
    private String model;
    private int weight;
    private Boolean isSailboat;

    protected BaseBoat(String model, int weight,
                       Boolean isSailboat) {
        setModel(model);
        setWeight(weight);
        this.isSailboat = isSailboat;
    }

    private void setModel(String model) {
        Validator.validateModelLength(model,
                Constants.MIN_BOAT_MODEL_LENGTH);
        this.model = model;
    }

    private void setWeight(int weight) {
        Validator.validatePropertyValue(weight,
                "Weight");
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public Boolean isSailboat() {
        return isSailboat;
    }

    @Override
    public String getModel() {
        return model;
    }

    public abstract double calculateRaceSpeed(Race race);
}


