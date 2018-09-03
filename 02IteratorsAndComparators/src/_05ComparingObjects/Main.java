package _05ComparingObjects;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 17.7.2018 г.
 * Time: 14:19 ч.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(System.in));

        List<Person> people = new ArrayList<>();

        String input;
        while (true) {
            if ("END".equals(input = bufferedReader.readLine())) {
                break;
            }

            String[] personArgs = input.split("\\s+");

            Person person = new Person(personArgs[0],
                    Integer.parseInt(personArgs[1]),
                    personArgs[2]);

            people.add(person);
        }

        int personIndex = Integer.parseInt(bufferedReader.readLine()) - 1;

        Person person = people.get(personIndex);

        int samePersonCount = people.stream()
                .filter(p -> p.compareTo(person) == 0)
                .collect(Collectors.toList())
                .size();

        if (samePersonCount == 1) {
            System.out.println("No matches");
        } else {
            System.out.println(String.format("%d %d %d",
                    samePersonCount,
                    people.size() - samePersonCount,
                    people.size()));
        }
    }
}