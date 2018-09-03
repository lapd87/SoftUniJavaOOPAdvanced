package _01BoatRacingSimulator.models;

import _01BoatRacingSimulator.contracts.Boat;
import _01BoatRacingSimulator.contracts.Race;
import _01BoatRacingSimulator.exceptions.DuplicateModelException;
import _01BoatRacingSimulator.utility.Constants;
import _01BoatRacingSimulator.utility.Validator;

import java.util.*;

public class RaceImpl implements Race<Boat> {

    private int distance;
    private int windSpeed;
    private int oceanCurrentSpeed;
    private Boolean allowsMotorBoats;
    private Map<String, Boat> registeredBoats;

    public RaceImpl(int distance, int windSpeed,
                    int oceanCurrentSpeed,
                    Boolean allowsMotorBoats) {
        this.setDistance(distance);
        this.windSpeed = windSpeed;
        this.oceanCurrentSpeed = oceanCurrentSpeed;
        this.allowsMotorBoats = allowsMotorBoats;
        this.registeredBoats = new LinkedHashMap<>();
    }


    private void setDistance(int distance) {
        Validator.validatePropertyValue(distance,
                "Distance");
        this.distance = distance;
    }

    @Override
    public int getDistance() {
        return distance;
    }

    @Override
    public int getWindSpeed() {
        return windSpeed;
    }

    @Override
    public int getOceanCurrentSpeed() {
        return oceanCurrentSpeed;
    }

    @Override
    public Boolean getAllowsEngines() {
        return allowsMotorBoats;
    }

    @Override
    public void addParticipant(Boat boat) throws DuplicateModelException {
        if (this.registeredBoats.containsKey(boat.getModel())) {
            throw new DuplicateModelException(
                    Constants.DUPLICATE_MODEL_MESSAGE);
        }

        this.registeredBoats.put(boat.getModel(), boat);
    }

    @Override
    public List<Boat> getParticipants() {
        return new ArrayList<>(this.registeredBoats.values());
    }
}