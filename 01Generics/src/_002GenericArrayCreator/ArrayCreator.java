package _002GenericArrayCreator;

import java.lang.reflect.Array;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 11.7.2018 г.
 * Time: 10:56 ч.
 */
public class ArrayCreator {

    public static <T> T[] create(int length, T item) {
        T[] array = (T[]) new Object[length];

        for (int i = 0; i < length; i++) {
            array[i] = item;
        }

        return array;
    }

    public static <T> T[] create(Class<T> clazz, int length, T item) {
        T[] array = (T[]) Array.newInstance(clazz, length);

        for (int i = 0; i < length; i++) {
            array[i] = item;
        }

        return array;
    }
}