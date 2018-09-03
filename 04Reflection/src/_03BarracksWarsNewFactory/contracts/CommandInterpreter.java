package _03BarracksWarsNewFactory.contracts;

public interface CommandInterpreter {

	Executable interpretCommand(String[] data, String commandName);
}
