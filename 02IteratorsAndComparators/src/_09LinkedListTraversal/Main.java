package _09LinkedListTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 17.7.2018 г.
 * Time: 19:52 ч.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(System.in));

        GenericLinkedList genericLinkedList = new GenericLinkedList();

        int n = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < n; i++) {
            String[] commandArgs = bufferedReader.readLine()
                    .split("\\s+");

            String command = commandArgs[0];

            switch (command) {
                case "Add":
                    genericLinkedList.add(commandArgs[1]);
                    break;
                case "Remove":
                    genericLinkedList.remove(commandArgs[1]);
                    break;
            }
        }

        System.out.println(genericLinkedList.getSize());

        StringBuilder stringBuilder = new StringBuilder();
        for (Object o : genericLinkedList) {
            stringBuilder.append(o)
                    .append(" ");
        }

        System.out.println(stringBuilder.toString().trim());
    }
}