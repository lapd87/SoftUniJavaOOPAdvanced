package _007GenericAddAllMethod;

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
        Collections.addAll(integers, 1, 2,null, 2,null);

        List<Double> doubles = new ArrayList<>();
        Collections.addAll(doubles, 1.2, 3.2,5.5);

        List<Number> destination = new ArrayList<>();
        ListUtils.addAll(destination,integers);
        ListUtils.addAll(destination,doubles);

        System.out.println(destination);
    }
}