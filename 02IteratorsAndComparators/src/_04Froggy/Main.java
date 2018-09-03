package _04Froggy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 17.7.2018 г.
 * Time: 11:10 ч.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(System.in));

        int[] input = Arrays
                .stream(bufferedReader.readLine()
                        .replace(",", " ")
                        .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        String command = bufferedReader.readLine();

        Lake lake = new Lake(Arrays.stream(input)
                .boxed()
                .collect(Collectors.toList()));

        if ("END".equals(command)) {
            StringBuilder stringBuilder = new StringBuilder();

            lake.forEach(e -> stringBuilder.append(e)
                    .append(" "));

            System.out.println(stringBuilder.toString()
                    .trim()
                    .replace(" ", ", "));
        }
    }
}