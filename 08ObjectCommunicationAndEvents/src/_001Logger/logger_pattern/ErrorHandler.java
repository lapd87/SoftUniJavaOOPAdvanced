package _001Logger.logger_pattern;

import _001Logger.logger_pattern.enums.LogType;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 4.8.2018 г.
 * Time: 18:41 ч.
 */
public class ErrorHandler extends BaseHandler {

    @Override
    public void handle(LogType logType, String message) {
        if (logType == LogType.ERROR) {
            System.out.println(logType.name() + ": " + message);
        } else {
            super.passToSuccessor(logType, message);
        }
    }
}