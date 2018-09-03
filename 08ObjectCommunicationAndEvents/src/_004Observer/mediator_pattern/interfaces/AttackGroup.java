package _004Observer.mediator_pattern.interfaces;

import _004Observer.contracts.Attacker;
import _004Observer.contracts.Target;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 4.8.2018 г.
 * Time: 19:21 ч.
 */
public interface AttackGroup {
    void addMember(Attacker attacker);

    void groupTarget(Target target);

    void groupAttack();
}
