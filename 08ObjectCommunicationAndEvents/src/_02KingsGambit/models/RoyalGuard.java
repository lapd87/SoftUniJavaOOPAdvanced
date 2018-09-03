package _02KingsGambit.models;

import _02KingsGambit.contracts.Killable;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 5.8.2018 г.
 * Time: 12:10 ч.
 */
public class RoyalGuard extends Unit implements Killable {

    private boolean isKilled;

    public RoyalGuard(String name) {
        super(name);
        this.isKilled = false;
    }

    @Override
    public boolean isKilled() {
        return isKilled;
    }

    @Override
    public void die() {
        isKilled = true;
    }

    @Override
    public void handleAttack() {
        System.out.println(String.format("Royal Guard %s is defending!",
                super.getName()));
    }
}