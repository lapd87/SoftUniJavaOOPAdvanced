package _10InfernoInfinity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 19.7.2018 г.
 * Time: 08:53 ч.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(System.in));

        Map<String, Weapon> weapons = new HashMap<>();

        String input;
        while (true) {
            if ("END".equals(input = bufferedReader.readLine())) {
                break;
            }

            String[] commandArgs = input.split(";");
            String command = commandArgs[0];

            try {
                Weapon weapon = null;
                switch (command) {
                    case "Create":
                        weapon = new Weapon(commandArgs[1],
                                commandArgs[2]);
                        weapons.putIfAbsent(commandArgs[2],
                                weapon);
                        break;
                    case "Add":
                        weapon = weapons.get(commandArgs[1]);
                        if (weapon != null) {
                            weapon.addGem(Integer.parseInt(commandArgs[2]),
                                    commandArgs[3]);
                        }
                        break;
                    case "Remove":
                        weapon = weapons.get(commandArgs[1]);
                        if (weapon != null) {
                            weapon.removeGem(Integer.parseInt(commandArgs[2]));
                        }
                        break;
                    case "Print":
                        weapon = weapons.get(commandArgs[1]);
                        if (weapon != null) {
                            System.out.println(weapon);
                        }
                        break;
                }
            } catch (IllegalArgumentException ignored) {
                ;
            }
        }

    }
}