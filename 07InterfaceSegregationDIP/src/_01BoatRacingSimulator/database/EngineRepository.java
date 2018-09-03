package _01BoatRacingSimulator.database;

import _01BoatRacingSimulator.contracts.Engine;
import _01BoatRacingSimulator.contracts.Repository;
import _01BoatRacingSimulator.exceptions.DuplicateModelException;
import _01BoatRacingSimulator.exceptions.NonExistantModelException;
import _01BoatRacingSimulator.utility.Constants;

import java.util.LinkedHashMap;
import java.util.Map;

public class EngineRepository implements Repository<Engine> {

    private Map<String, Engine> engines;

    public EngineRepository() {
        this.engines = new LinkedHashMap<>();
    }

    @Override
    public void add(Engine engine) throws DuplicateModelException {
        if (this.engines.containsKey(engine.getModel())) {
            throw new DuplicateModelException(Constants.DUPLICATE_MODEL_MESSAGE);
        }

        this.engines.put(engine.getModel(), engine);
    }

    @Override
    public Engine getItem(String model) throws NonExistantModelException {
        if (!this.engines.containsKey(model)) {
            throw new NonExistantModelException(Constants.NON_EXISTENT_MODEL_MESSAGE);
        }

        return this.engines.get(model);
    }
}
