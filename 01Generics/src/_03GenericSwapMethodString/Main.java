package _03GenericSwapMethodString;

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

        List<Box<String>> stringBox = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Box<String> box = new Box();
            box.setElement(bufferedReader.readLine());
            stringBox.add(box);
        }

        String[] input = bufferedReader.readLine()
                .split("\\s+");

        int firstIndex = Integer.parseInt(input[0]);
        int secondIndex = Integer.parseInt(input[1]);

        swap(stringBox, firstIndex, secondIndex);

        stringBox.forEach(System.out::println);
    }

    public static <T> void swap(List<Box<T>> data,
                                int firstIndex, int secondIndex) {

        Box<T> temp = data.get(firstIndex);

        data.set(firstIndex, data.get(secondIndex));
        data.set(secondIndex, temp);
    }
}