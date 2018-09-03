package _01GenericBox;

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

        stringBox.forEach(System.out::println);
    }
}