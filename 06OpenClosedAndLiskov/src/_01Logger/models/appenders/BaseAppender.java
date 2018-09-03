package _01Logger.models.appenders;

import _01Logger.enums.ReportLevel;
import _01Logger.interfaces.Appender;
import _01Logger.interfaces.Layout;
import _01Logger.interfaces.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 1.8.2018 г.
 * Time: 18:03 ч.
 */
public abstract class BaseAppender implements Appender {

    private static final Enum DEFAULT_REPORT_LEVEL = ReportLevel.INFO;

    private Layout layout;
    private Enum reportLevelThreshold;
    private List<Log> logs;


    BaseAppender(Layout layout) {
        this.layout = layout;
        reportLevelThreshold = DEFAULT_REPORT_LEVEL;
        this.logs = new ArrayList<>();
    }

    String getLogsData() {
        StringBuilder stringBuilder = new StringBuilder();

        for (Log log : this.logs) {
            stringBuilder.append(this.layout.formatLog(log))
                    .append(System.lineSeparator());
        }

        return stringBuilder.toString().trim();
    }

    @Override
    public void setReportLevelThreshold(String reportLevelThreshold) {
        this.reportLevelThreshold = ReportLevel
                .valueOf(reportLevelThreshold.toUpperCase());
    }

    @Override
    public void append(Log log) {
        if (log.getReportLevel().ordinal() >= reportLevelThreshold.ordinal()) {
            this.logs.add(log);
        }
    }

    @Override
    public String getAppenderInfo() {
        return String.format("Appender type: %s, Layout type: %s," +
                        " Report level: %s, Messages appended: %d",
                this.getClass().getSimpleName(),
                this.layout.getClass().getSimpleName(),
                this.reportLevelThreshold,
                this.logs.size());
    }
}