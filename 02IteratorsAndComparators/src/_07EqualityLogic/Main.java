package _07EqualityLogic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.TreeSet;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 17.7.2018 г.
 * Time: 15:33 ч.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(System.in));

        TreeSet<Person> firstSet = new TreeSet<>();
        HashSet<Person> secondSet = new HashSet<>();

        int n = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < n; i++) {
            String[] personArgs = bufferedReader.readLine()
                    .split("\\s+");

            Person person = new Person(personArgs[0],
                    Integer.parseInt(personArgs[1]));

            firstSet.add(person);
            secondSet.add(person);
        }

        System.out.println(firstSet.size());
        System.out.println(secondSet.size());
    }
}