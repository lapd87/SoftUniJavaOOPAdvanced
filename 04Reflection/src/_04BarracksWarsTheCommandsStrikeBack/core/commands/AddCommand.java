package _04BarracksWarsTheCommandsStrikeBack.core.commands;


import _04BarracksWarsTheCommandsStrikeBack.contracts.Repository;
import _04BarracksWarsTheCommandsStrikeBack.contracts.Unit;
import _04BarracksWarsTheCommandsStrikeBack.contracts.UnitFactory;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 26.7.2018 г.
 * Time: 16:34 ч.
 */
public class AddCommand extends BaseCommand {


    protected AddCommand(String[] data, Repository repository,
                         UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() {
        String unitType = super.getData()[1];
        Unit unitToAdd = super.getUnitFactory().createUnit(unitType);

        super.getRepository().addUnit(unitToAdd);
        return unitType + " added!";
    }
}