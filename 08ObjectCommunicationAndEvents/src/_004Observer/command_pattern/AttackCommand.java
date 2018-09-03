package _004Observer.command_pattern;

import _004Observer.command_pattern.interfaces.Command;
import _004Observer.contracts.Attacker;

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