package _01BoatRacingSimulator.database;

import _01BoatRacingSimulator.contracts.Boat;
import _01BoatRacingSimulator.contracts.Repository;
import _01BoatRacingSimulator.exceptions.DuplicateModelException;
import _01BoatRacingSimulator.exceptions.NonExistantModelException;
import _01BoatRacingSimulator.utility.Constants;

import java.util.LinkedHashMap;
import java.util.Map;

public class BoatRepository implements Repository<Boat> {

    private Map<String, Boat> boats;

    public BoatRepository() {
        this.boats = new LinkedHashMap<>();
    }

    @Override
    public void add(Boat boat) throws DuplicateModelException {
        if (this.boats.containsKey(boat.getModel())) {
            throw new DuplicateModelException(Constants.DUPLICATE_MODEL_MESSAGE);
        }

        this.boats.put(boat.getModel(), boat);
    }

    @Override
    public Boat getItem(String model) throws NonExistantModelException {
        if (!this.boats.containsKey(model)) {
            throw new NonExistantModelException(Constants.NON_EXISTENT_MODEL_MESSAGE);
        }

        return this.boats.get(model);
    }

}
