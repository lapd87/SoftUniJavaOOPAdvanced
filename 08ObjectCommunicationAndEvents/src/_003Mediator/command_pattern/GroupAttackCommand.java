package _003Mediator.command_pattern;

import _003Mediator.command_pattern.interfaces.Command;
import _003Mediator.mediator_pattern.interfaces.AttackGroup;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 4.8.2018 г.
 * Time: 19:29 ч.
 */
public class GroupAttackCommand implements Command {

    private AttackGroup attackGroup;

    public GroupAttackCommand(AttackGroup attackGroup) {
        this.attackGroup = attackGroup;
    }

    @Override
    public void execute() {
        attackGroup.groupAttack();
    }
}