package _003Mediator.command_pattern;

import _003Mediator.command_pattern.interfaces.Command;
import _003Mediator.command_pattern.interfaces.Executor;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 4.8.2018 г.
 * Time: 19:10 ч.
 */
public class CommandExecutor implements Executor {

    @Override
    public void executeCommand(Command command) {
        command.execute();
    }
}