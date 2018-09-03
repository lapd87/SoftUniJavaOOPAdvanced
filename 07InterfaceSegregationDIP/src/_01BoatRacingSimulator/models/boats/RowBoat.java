package _01BoatRacingSimulator.models.boats;

import _01BoatRacingSimulator.contracts.Race;
import _01BoatRacingSimulator.utility.Validator;

public class RowBoat extends BaseBoat {
    private static final double OARS_MULTIPLIER = 100.0;

    private int oars;

    public RowBoat(String model, int weight, int oars) {
        super(model, weight, true);
        setOars(oars);
    }

    private void setOars(int oars) {
        Validator.validatePropertyValue(oars,
                "Oars");
        this.oars = oars;
    }

    @Override
    public double calculateRaceSpeed(Race race) {
        return (oars * OARS_MULTIPLIER)
                - super.getWeight()
                + race.getOceanCurrentSpeed();
    }
}


