package _002Command;

import _002Command.contracts.Attacker;
import _002Command.contracts.Target;
import _002Command.logger_pattern.CombatHandler;
import _002Command.logger_pattern.EventHandler;
import _002Command.logger_pattern.interfaces.Handler;
import _002Command.models.Dragon;
import _002Command.models.Warrior;
import _002Command.command_pattern.AttackCommand;
import _002Command.command_pattern.CommandExecutor;
import _002Command.command_pattern.TargetCommand;
import _002Command.command_pattern.interfaces.Command;
import _002Command.command_pattern.interfaces.Executor;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 4.8.2018 г.
 * Time: 18:16 ч.
 */
public class Main {
    public static void main(String[] args) {
        Handler combatHandler = new CombatHandler();
        Handler eventHandler = new EventHandler();

        combatHandler.setSuccessor(eventHandler);

        Attacker warrior = new Warrior("Warrior", 10, combatHandler);
        Target dragon = new Dragon("Dragon", 100, 25, combatHandler);

        Executor executor = new CommandExecutor();
        Command targetCommand = new TargetCommand(warrior, dragon);
        Command attackCommand = new AttackCommand(warrior);

        executor.executeCommand(targetCommand);
        executor.executeCommand(attackCommand);
    }
}