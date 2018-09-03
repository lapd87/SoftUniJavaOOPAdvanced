package _05BarracksWarsReturnOfTheDependencies.core.commands;

import _05BarracksWarsReturnOfTheDependencies.annotations.Inject;
import _05BarracksWarsReturnOfTheDependencies.contracts.Executable;
import _05BarracksWarsReturnOfTheDependencies.contracts.Repository;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 26.7.2018 г.
 * Time: 16:52 ч.
 */
public class ReportCommand implements Executable {

    @Inject
    private Repository repository;

    private ReportCommand() {
    }


    @Override
    public String execute() {
        return this.repository.getStatistics();
    }
}