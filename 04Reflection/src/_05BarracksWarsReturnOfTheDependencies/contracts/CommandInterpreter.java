package _05BarracksWarsReturnOfTheDependencies.contracts;


public interface CommandInterpreter {

	Executable interpretCommand(String[] data, String commandName);
}
