package _005NullFinder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 11.7.2018 г.
 * Time: 12:54 ч.
 */
public class ListUtils<T> {

    public static <T extends Comparable<T>> T getMin(List<T> list) {

        if (list.isEmpty()) {
            throw new IllegalArgumentException();
        }

        T min = list.get(0);

        for (T element : list) {
            if (min.compareTo(element) > 0) {
                min = element;
            }
        }

        return min;
    }

    public static <T extends Comparable<T>> T getMax(List<T> list) {

        if (list.isEmpty()) {
            throw new IllegalArgumentException();
        }

        T max = list.get(0);

        for (T element : list) {
            if (max.compareTo(element) < 0) {
                max = element;
            }
        }

        return max;
    }

    public static <T> List<Integer> getNullIndices(List<T> list) {

        List<Integer> nullIndeces = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == null) {
                nullIndeces.add(i);
            }
        }

        return nullIndeces;
    }
}