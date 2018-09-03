package _02Blobs.core;

import _02Blobs.annotations.Inject;
import _02Blobs.interfaces.Executable;
import _02Blobs.interfaces.Repository;
import _02Blobs.interfaces.Runnable;
import _02Blobs.io.interfaces.Reader;
import _02Blobs.io.interfaces.Writer;
import _02Blobs.models.Blob;
import _02Blobs.observers.Subject;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 2.8.2018 г.
 * Time: 14:11 ч.
 */
public class Engine implements Runnable {

    private static final String INTERRUPT_COMMAND = "drop";

    private static final String COMMAND_PATH = "_02Blobs.core.commands.";
    private static final String COMMAND_NAME_SUFFIX = "Command";


    private String[] data;
    private Reader reader;
    private Writer writer;
    private Repository<Blob> blobRepository;
    private Subject subject;

    public Engine(Reader reader, Writer writer,
                  Repository<Blob> blobRepository, Subject subject) {
        this.reader = reader;
        this.writer = writer;
        this.blobRepository = blobRepository;
        this.subject = subject;
    }

    @Override
    public void run() {
        String input;
        while (true) {
            if (INTERRUPT_COMMAND.equals(input = reader.readLine())) {
                break;
            }

            String[] commandArgs = input.split("\\s+");

            this.interpretCommand(commandArgs, commandArgs[0]);

            this.subject.notifyAllObservers();
        }
    }

    private String parseCommandName(String commandName) {
        return Arrays.stream(commandName.split("-"))
                .map(c -> String.valueOf(c.charAt(0)).toUpperCase()
                        + c.substring(1).toLowerCase())
                .collect(Collectors.joining(""));
    }

    private void interpretCommand(String[] commandArgs, String commandName) {
        this.data = Arrays.stream(commandArgs)
                .skip(1)
                .toArray(String[]::new);

        try {
            String commandClassName = parseCommandName(commandName);

            Class<?> commandClass = Class.forName(COMMAND_PATH
                    + commandClassName + COMMAND_NAME_SUFFIX);

            Constructor<?> declaredConstructor = commandClass
                    .getDeclaredConstructor();
            declaredConstructor.setAccessible(true);

            Executable executable = (Executable) declaredConstructor
                    .newInstance();

            injectDependencies(executable);

            executable.execute();

        } catch (ClassNotFoundException
                | NoSuchMethodException
                | InstantiationException
                | IllegalAccessException
                | InvocationTargetException e) {
            throw new RuntimeException("Invalid command!");
        }
    }

    private <T> void injectDependencies(T command) throws IllegalAccessException {
        Field[] commandFields = command.getClass().getDeclaredFields();
        Field[] engineFields = this.getClass().getDeclaredFields();

        for (Field commandField : commandFields) {
            commandField.setAccessible(true);
            if (commandField.isAnnotationPresent(Inject.class)) {
                for (Field engineField : engineFields) {
                    engineField.setAccessible(true);
                    if (commandField.getType().getSimpleName()
                            .equals(engineField.getType().getSimpleName())
                            &&
                            commandField.getType()
                                    .equals(engineField.getType())) {
                        commandField.set(command, engineField.get(this));
                    }
                }
            }
        }
    }
}