package _004Observer;

import _004Observer.command_pattern.CommandExecutor;
import _004Observer.command_pattern.GroupAttackCommand;
import _004Observer.command_pattern.GroupTargetCommand;
import _004Observer.command_pattern.interfaces.Command;
import _004Observer.command_pattern.interfaces.Executor;
import _004Observer.logger_pattern.CombatHandler;
import _004Observer.logger_pattern.ErrorHandler;
import _004Observer.logger_pattern.EventHandler;
import _004Observer.logger_pattern.interfaces.Handler;
import _004Observer.mediator_pattern.Group;
import _004Observer.mediator_pattern.interfaces.AttackGroup;
import _004Observer.models.Dragon;
import _004Observer.models.Warrior;
import _004Observer.observer_pattern.interfaces.ObservableTarget;

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
        Handler errorHandler = new ErrorHandler();

        combatHandler.setSuccessor(eventHandler);
        eventHandler.setSuccessor(errorHandler);

        AttackGroup attackGroup = new Group();
        attackGroup.addMember(new Warrior("Warrior", 10, combatHandler));
        attackGroup.addMember(new Warrior("ElderWarrior", 13, combatHandler));

        ObservableTarget dragon = new Dragon("Dragon", 100, 25, combatHandler);

        Executor executor = new CommandExecutor();
        Command groupTargetCommand = new GroupTargetCommand(attackGroup, dragon);
        Command groupAttackCommand = new GroupAttackCommand(attackGroup);

        executor.executeCommand(groupTargetCommand);
        executor.executeCommand(groupAttackCommand);
    }
}