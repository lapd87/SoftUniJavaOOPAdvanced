package _11Threeuple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 13.7.2018 г.
 * Time: 09:39 ч.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(System.in));

        String[] personData = bufferedReader.readLine()
                .split("\\s+");

        String name = personData[0] + " " + personData[1];
        String address = personData[2];
        String town = personData[3];

        Threeuple threeuple = new Threeuple(name, address, town);
        System.out.println(threeuple);

        String[] personBeerAmount = bufferedReader.readLine()
                .split("\\s+");

        String personName = personBeerAmount[0];
        int beerLitres = Integer.parseInt(personBeerAmount[1]);
        boolean isDrunk = false;
        if ("drunk".equals(personBeerAmount[2])) {
            isDrunk = true;
        }

        threeuple = new Threeuple(personName, beerLitres, isDrunk);
        System.out.println(threeuple);

        String[] bankData = bufferedReader.readLine()
                .split("\\s+");

        String accountHolder = bankData[0];
        double floatNum = Double.parseDouble(bankData[1]);
        String bankName = bankData[2];

        threeuple = new Threeuple(accountHolder, floatNum, bankName);
        System.out.println(threeuple);

    }
}