package _001Logger.logger_pattern.interfaces;

import _001Logger.logger_pattern.enums.LogType;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 4.8.2018 г.
 * Time: 18:39 ч.
 */
public interface Handler {
    void handle(LogType logType, String message);

    void setSuccessor(Handler handler);
}
