package _004Observer.command_pattern;

import _004Observer.command_pattern.interfaces.Command;
import _004Observer.contracts.Attacker;
import _004Observer.contracts.Target;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 4.8.2018 г.
 * Time: 19:11 ч.
 */
public class TargetCommand implements Command {

    private Attacker attacker;
    private Target target;

    public TargetCommand(Attacker attacker, Target target) {
        this.attacker = attacker;
        this.target = target;
    }

    @Override
    public void execute() {
        this.attacker.setTarget(target);
    }
}