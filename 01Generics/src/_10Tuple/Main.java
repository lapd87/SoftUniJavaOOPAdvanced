package _10Tuple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 13.7.2018 г.
 * Time: 09:28 ч.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(System.in));

        String[] personData = bufferedReader.readLine()
                .split("\\s+");

        String name = personData[0] + " " + personData[1];
        String address = personData[2];

        Tuple tuple = new Tuple(name, address);
        System.out.println(tuple);

        String[] personBeerAmount = bufferedReader.readLine()
                .split("\\s+");

        String personName = personBeerAmount[0];
        int beerLitres = Integer.parseInt(personBeerAmount[1]);

        tuple = new Tuple(personName, beerLitres);
        System.out.println(tuple);

        String[] numbers = bufferedReader.readLine()
                .split("\\s+");

        int integerNum = Integer.parseInt(numbers[0]);
        double floatNum = Double.parseDouble(numbers[1]);

        tuple = new Tuple(integerNum, floatNum);
        System.out.println(tuple);
    }
}