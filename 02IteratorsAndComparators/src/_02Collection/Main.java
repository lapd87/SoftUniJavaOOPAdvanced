package _02Collection;

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

        ListyIterator listyIterator = new ListyIterator();

        String input;
        while (true) {
            if ("END".equals(input = bufferedReader.readLine())) {
                break;
            }

            String[] commandArgs = input.split("\\s+");

            String command = commandArgs[0];

            switch (command) {
                case "Create":
                    listyIterator.create(Arrays
                            .stream(commandArgs)
                            .skip(1)
                            .toArray(String[]::new));

                    if (listyIterator.getElements().isEmpty()){
                        System.out.println("Invalid Operation!");
                    }
                    break;
                case "Move":
                    System.out.println(listyIterator.move());
                    break;
                case "Print":
                    listyIterator.print();
                    break;
                case "HasNext":
                    System.out.println(listyIterator.hasNext());
                    break;
                case"PrintAll":
                    listyIterator.printAll();
                    break;
            }
        }
    }
}