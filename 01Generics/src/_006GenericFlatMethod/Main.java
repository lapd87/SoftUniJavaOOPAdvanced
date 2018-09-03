package _006GenericFlatMethod;

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
        Collections.addAll(integers, 1, 2, 3);

        List<Double> doubles = new ArrayList<>();
        Collections.addAll(doubles, 1.2, 3.2);

        List<List<? extends Number>> jagged = new ArrayList<>();
        Collections.addAll(jagged,integers,doubles);

        List<Number> dest = new ArrayList<>();
        ListUtils.flatten(dest,jagged);

        System.out.println(dest);
    }
}