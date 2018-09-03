package _05BarracksWarsReturnOfTheDependencies.core.commands;


import _05BarracksWarsReturnOfTheDependencies.annotations.Inject;
import _05BarracksWarsReturnOfTheDependencies.contracts.Executable;
import _05BarracksWarsReturnOfTheDependencies.contracts.Repository;
import _05BarracksWarsReturnOfTheDependencies.contracts.Unit;
import _05BarracksWarsReturnOfTheDependencies.contracts.UnitFactory;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 26.7.2018 г.
 * Time: 16:34 ч.
 */
public class AddCommand implements Executable {

    @Inject
    private String[] data;
    @Inject
    private Repository repository;
    @Inject
    private UnitFactory unitFactory;

    private AddCommand() {
    }

    @Override
    public String execute() {
        String unitType = this.data[1];
        Unit unitToAdd = this.unitFactory.createUnit(unitType);

        this.repository.addUnit(unitToAdd);
        return unitType + " added!";
    }
}