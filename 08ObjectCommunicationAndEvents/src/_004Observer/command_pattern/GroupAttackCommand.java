package _004Observer.command_pattern;

import _004Observer.command_pattern.interfaces.Command;
import _004Observer.mediator_pattern.interfaces.AttackGroup;

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