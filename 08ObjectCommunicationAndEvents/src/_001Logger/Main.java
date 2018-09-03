package _001Logger;

import _001Logger.logger_pattern.CombatHandler;
import _001Logger.logger_pattern.ErrorHandler;
import _001Logger.logger_pattern.EventHandler;
import _001Logger.logger_pattern.TargetHandler;
import _001Logger.logger_pattern.enums.LogType;
import _001Logger.logger_pattern.interfaces.Handler;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 4.8.2018 г.
 * Time: 18:16 ч.
 */
public class Main {
    public static void main(String[] args) {
        Handler combatHandler = new CombatHandler();
        Handler errorHandler = new ErrorHandler();
        Handler eventHandler = new EventHandler();
        Handler targetHandler = new TargetHandler();

        combatHandler.setSuccessor(errorHandler);
        errorHandler.setSuccessor(eventHandler);
        eventHandler.setSuccessor(targetHandler);

        combatHandler.handle(LogType.ATTACK, "some attack");
        combatHandler.handle(LogType.ERROR, "some error");
        combatHandler.handle(LogType.EVENT, "some event");
    }
}