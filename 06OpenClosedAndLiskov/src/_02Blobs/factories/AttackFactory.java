package _02Blobs.factories;

import _02Blobs.interfaces.Attack;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 2.8.2018 г.
 * Time: 15:06 ч.
 */
public class AttackFactory {

    private static final String ATTACK_CLASS_PATH = "_02Blobs.models.attacks.";


    public static Attack create(String attackType) {

        Attack attack = null;

        try {
            Class<?> commandClass = Class.forName(ATTACK_CLASS_PATH
                    + attackType);
            Constructor<?> declaredConstructor = commandClass
                    .getDeclaredConstructor();
            declaredConstructor.setAccessible(true);

            attack = (Attack) declaredConstructor
                    .newInstance();

        } catch (ClassNotFoundException
                | NoSuchMethodException
                | IllegalAccessException
                | InstantiationException
                | InvocationTargetException e) {
            e.printStackTrace();
        }

        return attack;
    }
}