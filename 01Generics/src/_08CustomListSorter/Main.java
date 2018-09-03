package _08CustomListSorter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 12.7.2018 г.
 * Time: 15:22 ч.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(System.in));

        CustomList customList = new CustomListImpl();

        String input;
        while (true) {
            if ("END".equals(input = bufferedReader.readLine())) {
                break;
            }

            String[] commandArgs = input.split("\\s+");

            String command = commandArgs[0];

            switch (command) {
                case "Add":
                    customList.add(commandArgs[1]);
                    break;
                case "Remove":
                    customList.remove(Integer.parseInt(commandArgs[1]));
                    break;
                case "Contains":
                    System.out.println(customList.contains(commandArgs[1]));
                    break;
                case "Swap":
                    customList.swap(Integer.parseInt(commandArgs[1]),
                            Integer.parseInt(commandArgs[2]));
                    break;
                case "Greater":
                    System.out.println(customList.countGreaterThan(commandArgs[1]));
                    break;
                case "Max":
                    System.out.println(customList.getMax());
                    break;
                case "Min":
                    System.out.println(customList.getMin());
                    break;
                case "Print":
                    customList.getElements()
                            .forEach(System.out::println);
                    break;
                case"Sort":
                    customList.sort();
                    break;
            }
        }
    }
}