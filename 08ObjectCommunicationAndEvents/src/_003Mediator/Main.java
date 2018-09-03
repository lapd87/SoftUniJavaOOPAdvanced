package _003Mediator;

import _003Mediator.command_pattern.CommandExecutor;
import _003Mediator.command_pattern.GroupAttackCommand;
import _003Mediator.command_pattern.GroupTargetCommand;
import _003Mediator.command_pattern.interfaces.Command;
import _003Mediator.command_pattern.interfaces.Executor;
import _003Mediator.contracts.Target;
import _003Mediator.logger_pattern.CombatHandler;
import _003Mediator.logger_pattern.EventHandler;
import _003Mediator.logger_pattern.interfaces.Handler;
import _003Mediator.mediator_pattern.Group;
import _003Mediator.mediator_pattern.interfaces.AttackGroup;
import _003Mediator.models.Dragon;
import _003Mediator.models.Warrior;

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

        AttackGroup attackGroup = new Group();
        attackGroup.addMember(new Warrior("Warrior", 10, combatHandler));
        attackGroup.addMember(new Warrior("ElderWarrior", 13, combatHandler));

        Target dragon = new Dragon("Dragon", 100, 25, combatHandler);

        Executor executor = new CommandExecutor();
        Command groupTargetCommand = new GroupTargetCommand(attackGroup, dragon);
        Command groupAttackCommand = new GroupAttackCommand(attackGroup);

        executor.executeCommand(groupTargetCommand);
        executor.executeCommand(groupAttackCommand);
    }
}