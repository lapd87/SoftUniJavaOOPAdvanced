package callofduty;

import callofduty.core.Engine;
import callofduty.core.MissionControlImpl;
import callofduty.core.MissionManagerImpl;
import callofduty.interfaces.InputReader;
import callofduty.interfaces.MissionControl;
import callofduty.interfaces.MissionManager;
import callofduty.interfaces.OutputWriter;
import callofduty.io.ConsoleReader;
import callofduty.io.ConsoleWriter;

public class Main {
    public static void main(String[] args) {

        InputReader inputReader = new ConsoleReader();
        OutputWriter outputWriter = new ConsoleWriter();
        MissionControl missionControl = new MissionControlImpl();
        MissionManager missionManager = new MissionManagerImpl(missionControl);

        Engine engine = new Engine(inputReader,
                outputWriter,
                missionManager);

        engine.run();
    }
}




