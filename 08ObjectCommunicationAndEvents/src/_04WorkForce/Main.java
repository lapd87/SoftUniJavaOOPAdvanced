package _04WorkForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 5.8.2018 г.
 * Time: 14:44 ч.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(System.in));

        WokrForce workForce = new WokrForce();

        String input;
        while (true) {
            if ("End".equals(input = bufferedReader.readLine())) {
                break;
            }

            String[] commandArgs = input.split("\\s+");
            String command = commandArgs[0];

            switch (command) {
                case "StandartEmployee":
                    workForce.addEmployee(
                            new StandartEmployee(commandArgs[1]));
                    break;
                case "PartTimeEmployee":
                    workForce.addEmployee(
                            new PartTimeEmployee(commandArgs[1]));
                    break;
                case "Job":
                    workForce.addJob(
                            new Job(commandArgs[1],
                                    Integer.parseInt(commandArgs[2]),
                                    workForce.getEmployeeByName(commandArgs[3])));
                    break;
                case "Pass":
                    workForce.updateJobs();
                    break;
                case "Status":
                    workForce.printStatus();
                    break;
            }
        }
    }
}