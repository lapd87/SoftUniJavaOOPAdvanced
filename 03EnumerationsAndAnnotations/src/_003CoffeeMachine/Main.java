package _003CoffeeMachine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 18.7.2018 г.
 * Time: 10:20 ч.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(System.in));

        CoffeeMachine coffeeMachine = new CoffeeMachine();

        String input;
        while (true) {
            if ("END".equals(input = bufferedReader.readLine())) {
                break;
            }

            String[] commandArgs = input.split("\\s+");
            if (commandArgs.length == 1) {
                coffeeMachine.insertCoin(commandArgs[0]);
            } else {
                coffeeMachine.buyCoffee(commandArgs[0],
                        commandArgs[1]);
            }
        }

        for (Coffee coffee : coffeeMachine.coffeesSold()) {
            System.out.println(coffee);
        }
    }
}