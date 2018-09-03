package _01BoatRacingSimulator.models.boats;

import _01BoatRacingSimulator.contracts.Engine;
import _01BoatRacingSimulator.contracts.Race;

public class PowerBoat extends BaseBoat {
    private static final double RACE_OCEAN_CURRENT_SPEED_DIVIDER = 5.0;

    private Engine firstEngine;
    private Engine secondEngine;

    public PowerBoat(String model, int weight,
                     Engine firstEngine, Engine secondEngine) {
        super(model, weight, false);
        this.firstEngine = firstEngine;
        this.secondEngine = secondEngine;
    }

    @Override
    public double calculateRaceSpeed(Race race) {
        return (firstEngine.getOutput() + secondEngine.getOutput())
                - super.getWeight()
                + (race.getOceanCurrentSpeed() / RACE_OCEAN_CURRENT_SPEED_DIVIDER);
    }
}


