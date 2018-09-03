package _004ListUtilities;

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
        Collections.addAll(integers,1,2,18,2,-1);

        Integer maxInteger = ListUtils.getMax(integers);
        System.out.println(maxInteger);

        List<String> strings = new ArrayList<>();
        Collections.addAll(strings,"a","b","c");

        String minString = ListUtils.getMin(strings);
        System.out.println(minString);
    }
}