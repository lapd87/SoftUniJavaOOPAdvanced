package _04BarracksWarsTheCommandsStrikeBack.core.commands;

import _04BarracksWarsTheCommandsStrikeBack.contracts.Repository;
import _04BarracksWarsTheCommandsStrikeBack.contracts.UnitFactory;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 26.7.2018 г.
 * Time: 16:55 ч.
 */
public class RetireCommand extends BaseCommand {

    protected RetireCommand(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() {
        try {
            String unitType = super.getData()[1];
            super.getRepository().removeUnit(unitType);

            return unitType + " retired!";
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }
    }
}