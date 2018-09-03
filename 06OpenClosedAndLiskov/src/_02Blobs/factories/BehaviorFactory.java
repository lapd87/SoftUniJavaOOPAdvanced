package _02Blobs.factories;

import _02Blobs.interfaces.Behavior;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 2.8.2018 г.
 * Time: 15:05 ч.
 */
public class BehaviorFactory {

    private static final String BEHAVIOUR_CLASS_PATH = "_02Blobs.models.behaviors.";


    public static Behavior create(String behaviourType) {

        Behavior behavior = null;

        try {
            Class<?> commandClass = Class.forName(BEHAVIOUR_CLASS_PATH
                    + behaviourType);
            Constructor<?> declaredConstructor = commandClass
                    .getDeclaredConstructor();
            declaredConstructor.setAccessible(true);

            behavior = (Behavior) declaredConstructor
                    .newInstance();

        } catch (ClassNotFoundException
                | NoSuchMethodException
                | IllegalAccessException
                | InstantiationException
                | InvocationTargetException e) {
            e.printStackTrace();
        }

        return behavior;
    }
}