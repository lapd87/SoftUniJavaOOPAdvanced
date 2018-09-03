package _05BarracksWarsReturnOfTheDependencies.core.commands;

import _05BarracksWarsReturnOfTheDependencies.annotations.Inject;
import _05BarracksWarsReturnOfTheDependencies.contracts.Executable;
import _05BarracksWarsReturnOfTheDependencies.contracts.Repository;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 26.7.2018 г.
 * Time: 16:55 ч.
 */
public class RetireCommand implements Executable {

    @Inject
    private String[] data;
    @Inject
    private Repository repository;

    private RetireCommand() {
    }

    @Override
    public String execute() {
        try {
            String unitType = this.data[1];
            this.repository.removeUnit(unitType);

            return unitType + " retired!";
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }
    }
}