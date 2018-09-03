package _01BoatRacingSimulator.database;

import _01BoatRacingSimulator.contracts.Boat;
import _01BoatRacingSimulator.contracts.Engine;
import _01BoatRacingSimulator.contracts.Repository;

public class BoatSimulatorDatabase {

    private Repository<Boat> boats;
    private Repository<Engine> engines;

    public BoatSimulatorDatabase(Repository<Boat> boats,
                                 Repository<Engine> engines) {
        this.boats = boats;
        this.engines = engines;
    }

    public Repository<Boat> getBoats() {
        return this.boats;
    }

    public Repository<Engine> getEngines() {
        return this.engines;
    }
}
