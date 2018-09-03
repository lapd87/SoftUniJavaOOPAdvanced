package _03BarracksWarsNewFactory.core.factories;

import _03BarracksWarsNewFactory.contracts.Unit;
import _03BarracksWarsNewFactory.contracts.UnitFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class UnitFactoryImpl implements UnitFactory {

    private static final String UNITS_PACKAGE_NAME =
            "_03BarracksWarsNewFactory.models.units.";

    @Override
    public Unit createUnit(String unitType) {
        // TODOs: implement for problem 3

        Unit unit = null;
        try {
            Class<?> unitClass = Class.forName(UNITS_PACKAGE_NAME + unitType);

            Constructor<?> declaredConstructor = unitClass.getDeclaredConstructor();
            declaredConstructor.setAccessible(true);
            unit = (Unit) declaredConstructor.newInstance();

        } catch (ClassNotFoundException
                | NoSuchMethodException
                | InstantiationException
                | IllegalAccessException
                | InvocationTargetException e) {
            e.printStackTrace();
        }

        return unit;
    }
}
