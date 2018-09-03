package callofduty.core;

import callofduty.interfaces.InputReader;
import callofduty.interfaces.MissionManager;
import callofduty.interfaces.OutputWriter;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 12.8.2018 г.
 * Time: 10:19 ч.
 */
public class Engine implements Runnable {

    private InputReader inputReader;
    private OutputWriter outputWriter;
    private MissionManager missionManager;

    public Engine(InputReader inputReader,
                  OutputWriter outputWriter,
                  MissionManager missionManager) {
        this.inputReader = inputReader;
        this.outputWriter = outputWriter;
        this.missionManager = missionManager;
    }

    @Override
    public void run() {
        String[] input;

        commandLoop:
        while (true) {
            input = inputReader.readLine()
                    .split("\\s+");

            String command = input[0].toLowerCase();
            List<String> arguments = Arrays.asList(input);

            Class commandClass = this.missionManager.getClass();

            Method[] methods = commandClass.getMethods();

            for (Method method : methods) {
                if (method.getName().equals(command)) {
                    try {
                        this.outputWriter
                                .println(String
                                        .valueOf(method
                                                .invoke(missionManager,
                                                        arguments)));
                        if ("over".equals(command)) {
                            break commandLoop;
                        }

                        break;
                    } catch (IllegalAccessException
                            | InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}