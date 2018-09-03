package _01Logger.models.logs;

import _01Logger.enums.ReportLevel;
import _01Logger.interfaces.Log;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 1.8.2018 г.
 * Time: 17:54 ч.
 */
public class LogImpl implements Log {

    private Enum reportLevel;
    private String dateTime;
    private String message;

    public LogImpl(String reportLevel, String dateTime, String message) {
        this.reportLevel = ReportLevel.valueOf(reportLevel);
        this.dateTime = dateTime;
        this.message = message;
    }

    @Override
    public String getDateTime() {
        return dateTime;
    }

    @Override
    public Enum getReportLevel() {
        return reportLevel;
    }

    @Override
    public String getMessage() {
        return message;
    }
}