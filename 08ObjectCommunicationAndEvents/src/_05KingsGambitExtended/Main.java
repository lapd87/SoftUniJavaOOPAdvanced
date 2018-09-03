package _05KingsGambitExtended;

import _05KingsGambitExtended.contracts.Attackable;
import _05KingsGambitExtended.contracts.Killable;
import _05KingsGambitExtended.models.Footman;
import _05KingsGambitExtended.models.King;
import _05KingsGambitExtended.models.RoyalGuard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 5.8.2018 г.
 * Time: 12:12 ч.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(System.in));

        String kingName = bufferedReader.readLine();
        String[] royalGuardsNames = bufferedReader.readLine()
                .split("\\s+");
        String[] footmenNames = bufferedReader.readLine()
                .split("\\s+");

        Attackable king = new King(kingName);

        Arrays.stream(royalGuardsNames)
                .forEach(name -> {
                    Killable royalGuard = new RoyalGuard(name);
                    king.addDefender(name, royalGuard);
                });

        Arrays.stream(footmenNames)
                .forEach(name -> {
                    Killable footman = new Footman(name);
                    king.addDefender(name, footman);
                });

        String input;
        while (true) {
            if ("End".equals(input = bufferedReader.readLine())) {
                break;
            }

            String[] commandArgs = input.split("\\s+");
            String command = commandArgs[0];

            switch (command) {
                case "Attack":
                    king.takeAttack();
                    break;
                case "Kill":
                    king.killDefender(commandArgs[1]);
                    break;
            }
        }
    }
}