package _04BarracksWarsTheCommandsStrikeBack.core.commands;


import _04BarracksWarsTheCommandsStrikeBack.contracts.Executable;
import _04BarracksWarsTheCommandsStrikeBack.contracts.Repository;
import _04BarracksWarsTheCommandsStrikeBack.contracts.UnitFactory;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 26.7.2018 г.
 * Time: 16:32 ч.
 */
public abstract class BaseCommand implements Executable {

    private String[] data;
    private Repository repository;
    private UnitFactory unitFactory;

    protected BaseCommand(String[] data, Repository repository,
                          UnitFactory unitFactory) {
        this.data = data;
        this.repository = repository;
        this.unitFactory = unitFactory;
    }

    protected String[] getData() {
        return data;
    }

    protected Repository getRepository() {
        return repository;
    }

    protected UnitFactory getUnitFactory() {
        return unitFactory;
    }
}