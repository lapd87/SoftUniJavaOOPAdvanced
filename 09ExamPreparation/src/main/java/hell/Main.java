package hell;

import hell.entities.heroes.Assassin;
import hell.entities.heroes.Barbarian;
import hell.entities.heroes.Wizard;
import hell.entities.items.CommonItem;
import hell.entities.items.RecipeItem;
import hell.entities.miscellaneous.HeroInventory;
import hell.interfaces.*;
import hell.io.impl.ConsoleReader;
import hell.io.impl.ConsoleWriter;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    private static final Map<String, Hero> heroes = new LinkedHashMap<>();

    public static void main(String[] args) {
        InputReader reader = new ConsoleReader();
        OutputWriter writer = new ConsoleWriter();

        String input;
        while (true) {
            if ("Quit".equals(input = reader.readLine())) {
                writer.writeLine(printHeroes());
                break;
            }

            String[] commandArgs = input.split("\\s+");
            String command = commandArgs[0];

            String result = null;
            switch (command) {
                case "Hero":
                    Hero hero = null;
                    switch (commandArgs[2]) {
                        case "Barbarian":
                            hero = new Barbarian(commandArgs[1], new HeroInventory());
                            break;
                        case "Assassin":
                            hero = new Assassin(commandArgs[1], new HeroInventory());
                            break;
                        case "Wizard":
                            hero = new Wizard(commandArgs[1], new HeroInventory());
                            break;
                    }

                    heroes.put(commandArgs[1], hero);

                    result = String.format("Created %s - %s",
                            commandArgs[2],
                            commandArgs[1]);
                    break;
                case "Item":
                    Item item = new CommonItem(commandArgs[1],
                            Integer.parseInt(commandArgs[3]),
                            Integer.parseInt(commandArgs[4]),
                            Integer.parseInt(commandArgs[5]),
                            Integer.parseInt(commandArgs[6]),
                            Integer.parseInt(commandArgs[7]));

                    heroes.get(commandArgs[2]).addItem(item);

                    result = String.format("Added item - %s to Hero - %s",
                            commandArgs[1],
                            commandArgs[2]);
                    break;
                case "Recipe":
                    Recipe recipe = new RecipeItem(commandArgs[1],
                            Integer.parseInt(commandArgs[3]),
                            Integer.parseInt(commandArgs[4]),
                            Integer.parseInt(commandArgs[5]),
                            Integer.parseInt(commandArgs[6]),
                            Integer.parseInt(commandArgs[7]),
                            Arrays.stream(commandArgs)
                                    .skip(8)
                                    .collect(Collectors.toList()));

                    heroes.get(commandArgs[2]).addRecipe(recipe);

                    result = String.format("Added recipe - %s to Hero - %s",
                            commandArgs[1],
                            commandArgs[2]);
                    break;
                case "Inspect":
                    result = heroes.get(commandArgs[1]).toString();
                    break;
            }

            writer.writeLine(result);
        }

    }

    private static String printHeroes() {
        StringBuilder stringBuilder = new StringBuilder();

        final int[] index = {1};

        heroes.values()
                .stream()
                .sorted(customComparator())
                .forEach(h -> {
                    String items = h.getItems().size() == 0 ? "None" : h.getItems()
                            .stream()
                            .map(Item::getName)
                            .collect(Collectors.joining(", "))
                            .trim();

                    stringBuilder.append(String.format("%d. %s: %s",
                            index[0]++,
                            h.getClass().getSimpleName(),
                            h.getName()))
                            .append(System.lineSeparator())
                            .append(String.format("###HitPoints: %s",
                                    h.getHitPoints()))
                            .append(System.lineSeparator())
                            .append(String.format("###Damage: %s",
                                    h.getDamage()))
                            .append(System.lineSeparator())
                            .append(String.format("###Strength: %s",
                                    h.getStrength()))
                            .append(System.lineSeparator())
                            .append(String.format("###Agility: %s",
                                    h.getAgility()))
                            .append(System.lineSeparator())
                            .append(String.format("###Intelligence: %s",
                                    h.getIntelligence()))
                            .append(System.lineSeparator())
                            .append(String.format("###Items: %s",
                                    items))
                            .append(System.lineSeparator());
                });

        return stringBuilder.toString().trim();
    }

    private static Comparator<? super Hero> customComparator() {
        return (h1, h2) -> {
            int firstComparator = Long.compare(
                    h2.getStrength() + h2.getAgility() + h2.getIntelligence(),
                    h1.getStrength() + h1.getAgility() + h1.getIntelligence());

            if (firstComparator != 0) {
                return firstComparator;
            }

            return Long.compare(
                    h2.getHitPoints() + h2.getDamage(),
                    h1.getHitPoints() + h1.getDamage());
        };
    }
}