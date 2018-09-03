package _08PetClinics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 17.7.2018 г.
 * Time: 16:52 ч.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(System.in));

        Manager manager = new Manager();

        int n = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < n; i++) {

            String[] commandArgs = bufferedReader.readLine()
                    .split("\\s+");

            String command = commandArgs[0];

            switch (command) {
                case "Create":
                    String secondCommand = commandArgs[1];
                    switch (secondCommand) {
                        case "Clinic":
                            manager.createClinic(commandArgs[2],
                                    Integer.parseInt(commandArgs[3]));
                            break;
                        case "Pet":
                            manager.createPet(commandArgs[2],
                                    Integer.parseInt(commandArgs[3]),
                                    commandArgs[4]);
                            break;
                    }
                    break;
                case "Add":
                    System.out.println(manager
                            .addPetToClinic(commandArgs[1],
                                    commandArgs[2]));
                    break;
                case "Release":
                    System.out.println(manager
                            .releasePetFromClinic(commandArgs[1]));
                    break;
                case "HasEmptyRooms":
                    System.out.println(manager
                            .hasEmptyRooms(commandArgs[1]));
                    break;
                case "Print":
                    if (commandArgs.length == 2) {
                        manager.printClinic(commandArgs[1]);
                    } else {
                        manager.printClinicRoom(commandArgs[1],
                                Integer.parseInt(commandArgs[2]));
                    }
                    break;
            }
        }
    }
}