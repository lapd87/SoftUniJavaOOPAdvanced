package _003Mediator.mediator_pattern;

import _003Mediator.contracts.Attacker;
import _003Mediator.contracts.Target;
import _003Mediator.mediator_pattern.interfaces.AttackGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 4.8.2018 г.
 * Time: 19:22 ч.
 */
public class Group implements AttackGroup {

    private List<Attacker> attackers;

    public Group() {
        this.attackers = new ArrayList<>();
    }

    @Override
    public void addMember(Attacker attacker) {
        attackers.add(attacker);
    }

    @Override
    public void groupTarget(Target target) {
        attackers.forEach(attacker -> attacker.setTarget(target));
    }

    @Override
    public void groupAttack() {
        attackers.forEach(Attacker::attack);
    }
}