package _01Logger.models.loggers;

import _01Logger.interfaces.Appender;
import _01Logger.interfaces.Log;
import _01Logger.interfaces.Logger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 1.8.2018 г.
 * Time: 17:50 ч.
 */
public class LoggerImpl implements Logger {

    private List<Appender> appenders;

    public LoggerImpl() {
        appenders = new ArrayList<>();
    }

    @Override
    public List<Appender> getAppenders() {
        return Collections.unmodifiableList(appenders);
    }

    @Override
    public void addAppender(Appender appender) {
        this.appenders.add(appender);
    }

    @Override
    public void addLogToAppenders(Log log) {
        for (Appender appender : appenders) {
            appender.append(log);
        }
    }

    @Override
    public String printLoggerInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Logger info")
                .append(System.lineSeparator());

        for (Appender appender : appenders) {
            stringBuilder.append(appender.getAppenderInfo())
            .append(System.lineSeparator());
        }

        return stringBuilder.toString().trim();
    }
}