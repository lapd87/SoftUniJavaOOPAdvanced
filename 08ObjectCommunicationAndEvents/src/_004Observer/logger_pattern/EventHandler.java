package _004Observer.logger_pattern;

import _004Observer.logger_pattern.enums.LogType;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 4.8.2018 г.
 * Time: 18:41 ч.
 */
public class EventHandler extends BaseHandler {

    @Override
    public void handle(LogType logType, String message) {
        if (logType == LogType.EVENT) {
            System.out.println(logType.name() + ": " + message);
        } else {
            super.passToSuccessor(logType, message);
        }
    }
}