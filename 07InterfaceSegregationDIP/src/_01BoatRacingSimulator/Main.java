package _01BoatRacingSimulator;

import _01BoatRacingSimulator.contracts.*;
import _01BoatRacingSimulator.contracts.Runnable;
import _01BoatRacingSimulator.controllers.BoatSimulatorControllerImpl;
import _01BoatRacingSimulator.core.AppEngine;
import _01BoatRacingSimulator.core.CommandHandlerImpl;
import _01BoatRacingSimulator.database.BoatRepository;
import _01BoatRacingSimulator.database.BoatSimulatorDatabase;
import _01BoatRacingSimulator.database.EngineRepository;
import _01BoatRacingSimulator.io.impl.ConsoleReader;
import _01BoatRacingSimulator.io.impl.ConsoleWriter;
import _01BoatRacingSimulator.io.interfaces.Reader;
import _01BoatRacingSimulator.io.interfaces.Writer;

public class Main {
    public static void main(String[] args) {

        Repository<Boat> boatRepository = new BoatRepository();
        Repository<Engine> engineRepository = new EngineRepository();

        BoatSimulatorDatabase boatSimulatorDatabase =
                new BoatSimulatorDatabase(boatRepository,
                        engineRepository);

        BoatSimulatorController boatSimulatorController =
                new BoatSimulatorControllerImpl(boatSimulatorDatabase);

        CommandHandler commandHandler =
                new CommandHandlerImpl(boatSimulatorController);

        Reader reader = new ConsoleReader();
        Writer writer = new ConsoleWriter();

        Runnable runnable = new AppEngine(commandHandler,
                reader, writer);

        runnable.run();
    }
}
