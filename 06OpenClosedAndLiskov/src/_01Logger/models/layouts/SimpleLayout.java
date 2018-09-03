package _01Logger.models.layouts;

import _01Logger.interfaces.Layout;
import _01Logger.interfaces.Log;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 29.7.2018 г.
 * Time: 16:50 ч.
 */
public class SimpleLayout implements Layout {

    private SimpleLayout() {
    }

    @Override
    public String formatLog(Log log) {
        return String.format("%s - %s - %s",
                log.getDateTime(),
                log.getReportLevel(),
                log.getMessage());
    }
}