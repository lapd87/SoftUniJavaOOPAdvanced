package _04BarracksWarsTheCommandsStrikeBack.core;


import _04BarracksWarsTheCommandsStrikeBack.contracts.Executable;
import _04BarracksWarsTheCommandsStrikeBack.contracts.Repository;
import _04BarracksWarsTheCommandsStrikeBack.contracts.UnitFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Engine implements Runnable {

    private static final String COMMAND_PATH = "_04BarracksWarsTheCommandsStrikeBack.core.commands.";
    private static final String COMMAND_NAME_SUFFIX = "Command";

    private Repository repository;
    private UnitFactory unitFactory;

    public Engine(Repository repository, UnitFactory unitFactory) {
        this.repository = repository;
        this.unitFactory = unitFactory;
    }

    @Override
    public void run() {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        while (true) {
            try {
                String input = reader.readLine();
                String[] data = input.split("\\s+");
                String commandName = data[0];
                String result = interpretCommand(data, commandName);
                if (result.equals("fight")) {
                    break;
                }
                System.out.println(result);
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // TODOs: refactor for problem 4
    private String interpretCommand(String[] data, String commandName) {

        try {
            String commandClassName = Character.toUpperCase(commandName.charAt(0))
                    + commandName.substring(1).toLowerCase();

            Class<?> commandClass = Class.forName(COMMAND_PATH
                    + commandClassName + COMMAND_NAME_SUFFIX);

            Constructor<?> declaredConstructor = commandClass.getDeclaredConstructor(String[].class,
                    Repository.class, UnitFactory.class);
            declaredConstructor.setAccessible(true);

            Executable executable = (Executable) declaredConstructor
                    .newInstance(data,
                            this.repository,
                            this.unitFactory);

            return executable.execute();

        } catch (ClassNotFoundException
                | NoSuchMethodException
                | InstantiationException
                | IllegalAccessException
                | InvocationTargetException e) {
            throw new RuntimeException("Invalid command!");
        }

//		String result;
//		switch (commandName) {
//			case "add":
//				result = this.addUnitCommand(data);
//				break;
//			case "report":
//				result = this.reportCommand(data);
//				break;
//			case "fight":
//				result = this.fightCommand(data);
//				break;
//			default:
//				throw new RuntimeException("Invalid command!");
//		}
//		return result;
    }

//	private String reportCommand(String[] data) {
//		String output = this.repository.getStatistics();
//		return output;
//	}

//	private String addUnitCommand(String[] data) throws ExecutionControl.NotImplementedException {
//		String unitType = data[1];
//		Unit unitToAdd = this.unitFactory.createUnit(unitType);
//		this.repository.addUnit(unitToAdd);
//		String output = unitType + " added!";
//		return output;
//	}

//	private String fightCommand(String[] data) {
//		return "fight";
//	}
}
