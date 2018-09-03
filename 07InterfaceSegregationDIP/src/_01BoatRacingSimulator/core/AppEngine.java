package _01BoatRacingSimulator.core;

import _01BoatRacingSimulator.contracts.CommandHandler;
import _01BoatRacingSimulator.contracts.Runnable;
import _01BoatRacingSimulator.io.interfaces.Reader;
import _01BoatRacingSimulator.io.interfaces.Writer;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AppEngine implements Runnable {

    private static final String INTERRUPT_COMMAND = "End";

    private CommandHandler commandHandler;
    private Reader reader;
    private Writer writer;

    public AppEngine(CommandHandler commandHandler,
                     Reader reader, Writer writer) {
        this.commandHandler = commandHandler;
        this.reader = reader;
        this.writer = writer;
    }

    @Override
    public void run() {
        String line;
        String commandName;
        List<String> commandParameters;

        while (true) {
            try {
                line = reader.readLine();

                if (INTERRUPT_COMMAND.equals(line)) {
                    break;
                }

                List<String> tokens = Arrays.asList(
                        line.split("\\\\"));
                commandName = tokens.get(0);
                commandParameters = tokens.stream()
                        .skip(1)
                        .collect(Collectors.toList());

                String commandResult = this.commandHandler
                        .executeCommand(commandName,
                                commandParameters);

                writer.writeLine(commandResult);
            } catch (Exception ex) {
                writer.writeLine(ex.getMessage());
            }
        }
    }
}
