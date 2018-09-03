package _06MirrorImage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 5.8.2018 г.
 * Time: 15:22 ч.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(System.in));

        String[] wizardArgs = bufferedReader.readLine()
                .split("\\s+");

        Wizard wizard = new Wizard(wizardArgs[0],
                Integer.parseInt(wizardArgs[1]));

        String input;
        while (true) {
            if ("END".equals(input = bufferedReader.readLine())) {
                break;
            }

            String[] commandArgs = input.split("\\s+");
            String command = commandArgs[1];

            switch (command) {
                case "FIREBALL":
                    wizard.useFireBall(Integer
                            .parseInt(commandArgs[0]));
                    break;
                case "REFLECTION":
                    wizard.useReflection(Integer
                            .parseInt(commandArgs[0]));
                    break;
            }
        }
    }
}