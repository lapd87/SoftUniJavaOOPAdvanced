package _05KingsGambitExtended.models;

import _05KingsGambitExtended.contracts.Attackable;
import _05KingsGambitExtended.contracts.Killable;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 5.8.2018 г.
 * Time: 12:10 ч.
 */
public class King extends Unit implements Attackable {

    private Map<String, Killable> defenders;

    public King(String name) {
        super(name);
        this.defenders = new LinkedHashMap<>();
    }

    @Override
    public void addDefender(String name, Killable defender) {
        defenders.put(name, defender);
    }

    @Override
    public void killDefender(String name) {
        defenders.get(name).die();
    }

    @Override
    public void takeAttack() {
        System.out.println(String.format("King %s is under attack!",
                super.getName()));

        defenders.values()
                .stream()
                .filter(d -> "RoyalGuard".equals(d.getClass().getSimpleName())
                        && !d.isKilled())
                .forEach(Killable::handleAttack);

        defenders.values()
                .stream()
                .filter(d -> "Footman".equals(d.getClass().getSimpleName())
                        && !d.isKilled())
                .forEach(Killable::handleAttack);
    }
}