package _01BoatRacingSimulator.models.boats;

import _01BoatRacingSimulator.contracts.Race;
import _01BoatRacingSimulator.utility.Constants;

public class SailBoat extends BaseBoat {
    private static final double SAIL_EFFICIENCY_DIVIDER = 100.0;
    private static final double RACE_OCEAN_CURRENT_SPEED_DIVIDER = 2.0;

    private int sailEfficiency;

    public SailBoat(String model, int weight, int sailEfficiency) {
        super(model, weight, true);
        setSailEfficiency(sailEfficiency);
    }

    private void setSailEfficiency(int sailEfficiency) {
        if (sailEfficiency < 1 || sailEfficiency > 100) {
            throw new IllegalArgumentException(
                    Constants.INCORRECT_SAIL_EFFICIENCY_MESSAGE);
        }
        this.sailEfficiency = sailEfficiency;
    }

    @Override
    public double calculateRaceSpeed(Race race) {
        return (race.getWindSpeed()
                * (sailEfficiency / SAIL_EFFICIENCY_DIVIDER))
                - super.getWeight()
                + (race.getOceanCurrentSpeed() / RACE_OCEAN_CURRENT_SPEED_DIVIDER);
    }
}


