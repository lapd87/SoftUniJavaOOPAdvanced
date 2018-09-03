package _01Logger.interfaces;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 29.7.2018 г.
 * Time: 16:27 ч.
 */
public interface Appender {

    void printAll();

    void setReportLevelThreshold(String reportLevelThreshold);

    void append(Log log);

    String getAppenderInfo();
}