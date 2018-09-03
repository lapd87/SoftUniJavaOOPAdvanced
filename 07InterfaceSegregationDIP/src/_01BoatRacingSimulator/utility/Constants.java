package _01BoatRacingSimulator.utility;

public class Constants {
    static final String INCORRECT_MODEL_LENGTH_MESSAGE = "Model's name must be at least %s symbols long.";

    static final String INCORRECT_PROPERTY_VALUE_MESSAGE = "%s must be a positive integer.";

    public static final String INCORRECT_SAIL_EFFICIENCY_MESSAGE = "Sail Effectiveness must be between [1...100].";

    public static final String INCORRECT_ENGINE_TYPE_MESSAGE = "Incorrect engine type.";

    public static final String DUPLICATE_MODEL_MESSAGE = "An entry for the given model already exists.";

    public static final String NON_EXISTENT_MODEL_MESSAGE = "The specified model does not exist.";

    public static final String RACE_ALREADY_EXISTS_MESSAGE = "The current race has already been set.";

    public static final String NO_SET_RACE_MESSAGE = "There is currently no race set.";

    public static final String INSUFFICIENT_CONTESTANTS_MESSAGE = "Not enough contestants for the race.";

    public static final String INCORRECT_BOAT_TYPE_MESSAGE = "The specified boat does not meet the race constraints.";

    public static final String SUCCESSFUL_ENGINE_CREATION_MESSAGE = "Engine model %s with %s HP and displacement %s " +
            "cm3 created successfully.";
    public static final String SUCCESSFUL_ROWBOAT_CREATION_MESSAGE = "Row boat with model %s registered successfully.";
    public static final String SUCCESSFUL_SAILBOAT_CREATION_MESSAGE = "Sail boat with model %s registered " +
            "successfully.";
    public static final String SUCCESSFUL_POWERBOAT_CREATION_MESSAGE = "Power boat with model %s registered " +
            "successfully.";
    public static final String SUCCESSFULLY_YACHT_CREATION_MESSAGE = "Yacht with model %s registered successfully.";
    public static final String SUCCESSFUL_RACE_CREATION_MESSAGE = "A new race with distance %s meters, wind speed " +
            "%s m/s and ocean current speed %s m/s has been set.";
    public static final String SUCCESSFUL_BOAT_RACE_SIGNING_MESSAGE = "Boat with model %s has signed up for the " +
            "current Race.";
    public static final String RACE_FINAL_RESULTS_MESSAGE = "%s place: %s Model: %s Time: %s";
    public static final String[] RACE_FINAL_RESULTS_PLACES_MESSAGE = new String[]{"First", "Second", "Third"};
    public static final String BOAT_DID_NOT_FINISH_MESSAGE = "Did not finish!";
    public static final String BOAT_FINISH_TIME_MESSAGE = "%.2f sec";
    public static final int RACE_FASTEST_BOATS_COUNT = 3;
    public static final int RACE_MINIMUM_BOATS_COUNT = 3;
    public static final String RACE_STATISTICS_MESSAGE = "%s -> %.2f%%";


    public static final int MIN_BOAT_MODEL_LENGTH = 5;

    public static final int MIN_BOAT_ENGINE_MODEL_LENGTH = 3;
}
