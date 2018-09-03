package _01BoatRacingSimulator.models.engines;

import _01BoatRacingSimulator.contracts.Engine;
import _01BoatRacingSimulator.enumeration.EngineType;
import _01BoatRacingSimulator.utility.Constants;
import _01BoatRacingSimulator.utility.Validator;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 3.8.2018 г.
 * Time: 20:42 ч.
 */
public abstract class BaseEngine implements Engine {

    private String model;
    private int horsepower;
    private int displacement;
    private int output;

    public BaseEngine(String model, int horsepower,
                      int displacement) {
        setModel(model);
        setHorsepower(horsepower);
        setDisplacement(displacement);
        setOutput();
    }

    private void setModel(String model) {
        Validator.validateModelLength(model,
                Constants.MIN_BOAT_ENGINE_MODEL_LENGTH);
        this.model = model;
    }

    private void setHorsepower(int horsepower) {
        Validator.validatePropertyValue(horsepower,
                "Horsepower");
        this.horsepower = horsepower;
    }

    private void setDisplacement(int displacement) {
        Validator.validatePropertyValue(displacement,
                "Displacement");
        this.displacement = displacement;
    }

    private void setOutput() {
        this.output = (this.horsepower * getHorsepowerMultiplier())
                + this.displacement;
    }

    private int getHorsepowerMultiplier() {
        return Enum.valueOf(EngineType.class, getEngineType())
                .getHorsepowerMultiplier();
    }

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public int getOutput() {
        return output;
    }

    protected abstract String getEngineType();
}