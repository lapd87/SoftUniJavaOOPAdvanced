package _003Mediator.command_pattern;

import _003Mediator.command_pattern.interfaces.Command;
import _003Mediator.contracts.Target;
import _003Mediator.mediator_pattern.interfaces.AttackGroup;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 4.8.2018 г.
 * Time: 19:27 ч.
 */
public class GroupTargetAndAttackCommand implements Command {

    private AttackGroup attackGroup;
    private Target target;

    public GroupTargetAndAttackCommand(AttackGroup attackGroup, Target target) {
        this.attackGroup = attackGroup;
        this.target = target;
    }

    @Override
    public void execute() {
        attackGroup.groupTarget(target);
        attackGroup.groupAttack();
    }
}