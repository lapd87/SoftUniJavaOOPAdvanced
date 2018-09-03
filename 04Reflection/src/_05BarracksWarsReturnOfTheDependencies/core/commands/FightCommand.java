package _05BarracksWarsReturnOfTheDependencies.core.commands;

import _05BarracksWarsReturnOfTheDependencies.annotations.Inject;
import _05BarracksWarsReturnOfTheDependencies.contracts.Executable;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 26.7.2018 г.
 * Time: 16:53 ч.
 */
public class FightCommand implements Executable {

    @Inject
    private String[] data;

    private FightCommand() {
    }

    @Override
    public String execute() {
        return this.data[0];
    }
}