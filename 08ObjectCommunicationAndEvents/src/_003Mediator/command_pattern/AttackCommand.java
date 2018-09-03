package _003Mediator.command_pattern;

import _003Mediator.command_pattern.interfaces.Command;
import _003Mediator.contracts.Attacker;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 4.8.2018 г.
 * Time: 19:11 ч.
 */
public class AttackCommand implements Command {

    private Attacker attacker;

    public AttackCommand(Attacker attacker) {
        this.attacker = attacker;
    }

    @Override
    public void execute() {
        this.attacker.attack();
    }
}