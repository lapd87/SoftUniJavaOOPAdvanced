package _004Observer.command_pattern;

import _004Observer.command_pattern.interfaces.Command;
import _004Observer.contracts.Target;
import _004Observer.mediator_pattern.interfaces.AttackGroup;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 4.8.2018 г.
 * Time: 19:27 ч.
 */
public class GroupTargetCommand implements Command {

    private AttackGroup attackGroup;
    private Target target;

    public GroupTargetCommand(AttackGroup attackGroup, Target target) {
        this.attackGroup = attackGroup;
        this.target = target;
    }

    @Override
    public void execute() {
        attackGroup.groupTarget(target);
    }
}