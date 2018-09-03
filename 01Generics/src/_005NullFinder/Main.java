package _005NullFinder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 11.7.2018 г.
 * Time: 13:01 ч.
 */
public class Main {
    public static void main(String[] args) {

        List<Integer> integers = new ArrayList<>();
        Collections.addAll(integers, 1, 2, null, 2, null);

        List<Integer> integerNulls = ListUtils.getNullIndices(integers);
        System.out.println(integerNulls);

        List<String> strings = new ArrayList<>();
        Collections.addAll(strings, "a", null, "c");

        List<Integer> stringNulls = ListUtils.getNullIndices(strings);
        System.out.println(stringNulls);
    }
}