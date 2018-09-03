package _001ExtendArrayList;

import java.util.Collections;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 29.7.2018 г.
 * Time: 15:28 ч.
 */
public class Main {
    public static void main(String[] args) {

        ExtendedArrayList<Integer> test = new ExtendedArrayList<>();
        Collections.addAll(test, 1, 100, 1000);

        System.out.println(test.min());
        System.out.println(test.max());

    }
}