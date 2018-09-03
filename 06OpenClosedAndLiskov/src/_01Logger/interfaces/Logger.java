package _01Logger.interfaces;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 29.7.2018 г.
 * Time: 16:27 ч.
 */
public interface Logger {

    void addLogToAppenders(Log log);

    List<Appender> getAppenders();

    void addAppender(Appender appender);

    String printLoggerInfo();
}
