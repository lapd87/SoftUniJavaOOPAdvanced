package _01HarvestingFields;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(System.in));

        Class<RichSoilLand> aClass = RichSoilLand.class;
        Field[] declaredFields = aClass.getDeclaredFields();

        String input;
        while (true) {
            if ("HARVEST".equals(input = bufferedReader.readLine())) {
                break;
            }

            Predicate predicate;

            switch (input) {
                case "private":
                    predicate = o -> {
                        Field field = (Field) o;
                        return Modifier.isPrivate(field.getModifiers());
                    };
                    break;
                case "protected":
                    predicate = o -> {
                        Field field = (Field) o;
                        return Modifier.isProtected(field.getModifiers());
                    };
                    break;
                case "public":
                    predicate = o -> {
                        Field field = (Field) o;
                        return Modifier.isPublic(field.getModifiers());
                    };
                    break;
                case "all":
                    predicate = o -> true;
                    break;
                default:
                    predicate = o -> false;
            }

            Field[] filtered = (Field[]) Arrays.stream(declaredFields)
                    .filter(predicate)
                    .toArray(Field[]::new);

            Arrays.stream(filtered)
                    .forEach(field -> System.out.printf("%s %s %s%n",
                    Modifier.toString(field.getModifiers()),
                    field.getType().getSimpleName(),
                    field.getName()));
        }
    }
}
