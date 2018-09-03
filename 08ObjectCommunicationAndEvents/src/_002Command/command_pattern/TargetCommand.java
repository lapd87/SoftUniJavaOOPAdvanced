package _002Command.command_pattern;

import _002Command.contracts.Attacker;
import _002Command.contracts.Target;
import _002Command.command_pattern.interfaces.Command;

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