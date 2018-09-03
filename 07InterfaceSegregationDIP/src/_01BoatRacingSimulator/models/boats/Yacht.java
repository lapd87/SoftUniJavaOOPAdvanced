package _01BoatRacingSimulator.models.boats;

import _01BoatRacingSimulator.contracts.Engine;
import _01BoatRacingSimulator.contracts.Race;
import _01BoatRacingSimulator.utility.Validator;

public class Yacht extends BaseBoat {
    private static final double RACE_OCEAN_CURRENT_SPEED_DIVIDER = 2.0;

    private Engine engine;
    private int cargoWeight;

    public Yacht(String model, int weight,
                 Engine engine, int cargoWeight) {
        super(model, weight, false);
        this.engine = engine;
        setCargoWeight(cargoWeight);
    }

    private void setCargoWeight(int cargoWeight) {
        Validator.validatePropertyValue(cargoWeight,
                "Cargo Weight");
        this.cargoWeight = cargoWeight;
    }

    @Override
    public double calculateRaceSpeed(Race race) {
        return engine.getOutput()
                - (super.getWeight() + cargoWeight)
                + (race.getOceanCurrentSpeed() / RACE_OCEAN_CURRENT_SPEED_DIVIDER);
    }
}


