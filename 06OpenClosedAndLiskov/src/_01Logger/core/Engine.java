package _01Logger.core;

import _01Logger.interfaces.Appender;
import _01Logger.interfaces.Logger;
import _01Logger.interfaces.Runnable;
import _01Logger.models.loggers.LoggerImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 1.8.2018 г.
 * Time: 19:00 ч.
 */
public class Engine implements Runnable {

    private static final String INTERRUPT_COMMAND = "END";

    private Logger logger;
    private CommandExecutor commandExecutor;

    public Engine() {
        logger = new LoggerImpl();
        commandExecutor = new CommandExecutor();
    }

    @Override
    public void run() {
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(System.in));

        try {
            int appendersCount = Integer.parseInt(bufferedReader.readLine());

            for (int i = 0; i < appendersCount; i++) {
                String[] appenderData = bufferedReader.readLine().split("\\s+");

                logger.addAppender(commandExecutor.createAppender(appenderData));
            }

            String input;
            while (true) {
                if (INTERRUPT_COMMAND.equals(input = bufferedReader.readLine())) {
                    for (Appender appender : logger.getAppenders()) {
                        appender.printAll();
                    }

                    System.out.println(logger.printLoggerInfo());
                    break;
                }

                String[] logData = input.split("\\|");

                logger.addLogToAppenders(commandExecutor
                        .createLog(logData));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}