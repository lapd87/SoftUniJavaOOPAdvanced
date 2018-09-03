package _14Refactoring;

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

            Class<Weapon> weaponClass = Weapon.class;
            CustomAnnotation annotation = null;
            if (weaponClass.isAnnotationPresent(CustomAnnotation.class)) {
                annotation = weaponClass.getAnnotation(CustomAnnotation.class);
            }

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
                    case "Compare":
                        Weapon firstWeapon = weapons.get(commandArgs[1]);
                        Weapon secondWeapon = weapons.get(commandArgs[2]);
                        if (firstWeapon != null && secondWeapon != null) {
                            if (firstWeapon.compareTo(secondWeapon) >= 0) {
                                System.out.println(String.format("%s (Item Level: %.1f)",
                                        firstWeapon,
                                        firstWeapon.getLevel()));
                            } else {
                                System.out.println(String.format("%s (Item Level: %.1f)",
                                        secondWeapon,
                                        secondWeapon.getLevel()));
                            }
                        }
                        break;
                    case "Author":
                        if (annotation != null) {
                            printAnnotationValue(command,
                                    annotation.author());
                        }
                        break;
                    case "Revision":
                        if (annotation != null) {
                            printAnnotationValue(command,
                                    String.valueOf(annotation.revision()));
                        }
                        break;
                    case "Description":
                        if (annotation != null) {
                            printAnnotationValue("Class description",
                                    annotation.description());
                        }
                        break;
                    case "Reviewers":
                        if (annotation != null) {
                            printAnnotationValue(command,
                                    String.join(", ",
                                            annotation.reviewers()));
                        }
                        break;
                }
            } catch (IllegalArgumentException ignored) {
                ;
            }
        }
    }

    private static void printAnnotationValue(String command, String annotation) {
        System.out.println(String.format("%s: %s",
                command,
                annotation));
    }
}