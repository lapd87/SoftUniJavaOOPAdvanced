package _05BarracksWarsReturnOfTheDependencies.data;


import _05BarracksWarsReturnOfTheDependencies.contracts.Repository;
import _05BarracksWarsReturnOfTheDependencies.contracts.Unit;

import java.util.Map;
import java.util.TreeMap;

public class UnitRepository implements Repository {

    private static final String NO_SUCH_UNIT_TYPE_EXCEPTION_MESSAGE = "No such units in repository.";

    private Map<String, Integer> amountOfUnits;

    public UnitRepository() {
        this.amountOfUnits = new TreeMap<>();
    }

    public void addUnit(Unit unit) {
        String unitType = unit.getClass().getSimpleName();
        if (!this.amountOfUnits.containsKey(unitType)) {
            this.amountOfUnits.put(unitType, 0);
        }

        int newAmount = this.amountOfUnits.get(unitType) + 1;
        this.amountOfUnits.put(unitType, newAmount);
    }

    public String getStatistics() {
        StringBuilder statBuilder = new StringBuilder();
        for (Map.Entry<String, Integer> entry : amountOfUnits.entrySet()) {
            String formattedEntry =
                    String.format("%s -> %d%n", entry.getKey(), entry.getValue());
            statBuilder.append(formattedEntry);
        }
        statBuilder.setLength(
                statBuilder.length() - System.lineSeparator().length());

        return statBuilder.toString();
    }

    public void removeUnit(String unitType) {
        // TODOs: implement for problem 4

        if (this.amountOfUnits.containsKey(unitType)) {
            Integer countOfUnits = this.amountOfUnits.get(unitType);
            if (countOfUnits > 0) {
                this.amountOfUnits.put(unitType, countOfUnits - 1);
                return;
            }
        }

        throw new IllegalArgumentException(NO_SUCH_UNIT_TYPE_EXCEPTION_MESSAGE);
    }
}
