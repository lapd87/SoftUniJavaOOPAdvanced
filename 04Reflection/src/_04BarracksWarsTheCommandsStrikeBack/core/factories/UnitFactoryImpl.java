package _04BarracksWarsTheCommandsStrikeBack.core.factories;


import _04BarracksWarsTheCommandsStrikeBack.contracts.Unit;
import _04BarracksWarsTheCommandsStrikeBack.contracts.UnitFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class UnitFactoryImpl implements UnitFactory {

    private static final String UNITS_PACKAGE_NAME =
            "_04BarracksWarsTheCommandsStrikeBack.models.units.";

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
