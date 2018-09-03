package _01BoatRacingSimulator.contracts;


import _01BoatRacingSimulator.exceptions.*;

import java.util.List;

public interface CommandHandler {
    String executeCommand(String name, List<String> parameters) throws DuplicateModelException, NonExistantModelException, RaceAlreadyExistsException, NoSetRaceException, InsufficientContestantsException;
}
