package _03StackIterator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 16.7.2018 г.
 * Time: 16:53 ч.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(System.in));

        Stack stack = new Stack();

        String input;
        while (true) {
            if ("END".equals(input = bufferedReader.readLine())) {
                for (Integer integer : stack) {
                    System.out.println(integer);
                }
                for (Integer integer : stack) {
                    System.out.println(integer);
                }
                break;
            }

            String[] commandArgs = input.replace(",", "")
                    .split("\\s+");

            String command = commandArgs[0];

            switch (command) {
                case "Push":
                    int[] elementsToPush = Arrays
                            .stream(commandArgs)
                            .skip(1)
                            .mapToInt(Integer::parseInt)
                            .toArray();

                    for (int element : elementsToPush) {
                        stack.push(element);
                    }
                    break;
                case "Pop":
                    stack.pop();
                    break;
            }
        }
    }
}
