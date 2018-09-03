package _06GenericCountMethodDouble;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 12.7.2018 г.
 * Time: 14:06 ч.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());

        List<ComparableBox<Double>> stringBox = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ComparableBox<Double> box = new ComparableBox();
            box.setElement(Double.valueOf(bufferedReader.readLine()));
            stringBox.add(box);
        }

        Double element = Double.valueOf(bufferedReader.readLine());
        ComparableBox<Double> elementBox = new ComparableBox<>();
        elementBox.setElement(element);

        int count = count(stringBox, elementBox);

        System.out.println(count);
    }

    public static <T> void swap(List<Box<T>> data,
                                int firstIndex, int secondIndex) {

        Box<T> temp = data.get(firstIndex);

        data.set(firstIndex, data.get(secondIndex));
        data.set(secondIndex, temp);
    }

    public static <T extends Comparable<T>> int count(List<ComparableBox<T>> data, ComparableBox<T> element) {
        int count = 0;

        for (ComparableBox<T> box : data) {
            if (box.compareTo(element) > 0) {
                count++;
            }
        }

        return count;
    }
}