package _004Observer.logger_pattern;

import _004Observer.logger_pattern.enums.LogType;
import _004Observer.logger_pattern.interfaces.Handler;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 4.8.2018 г.
 * Time: 18:42 ч.
 */
public abstract class BaseHandler implements Handler {

    private Handler successor;

    protected void passToSuccessor(LogType logType, String message) {
        if (successor != null) {
            successor.handle(logType, message);
        }
    }

    @Override
    public void setSuccessor(Handler handler) {
        this.successor = handler;
    }
}