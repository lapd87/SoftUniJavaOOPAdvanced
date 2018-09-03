package _005CodingTracker;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 18.7.2018 г.
 * Time: 11:00 ч.
 */
public class Tracker {
    @Author(name = "Pesho")
    public static void printMethodsByAuthor(Class<?> cl) {
        Map<String, List<String>> methodsByAuthor = new HashMap<>();
        Method[] methods = cl.getDeclaredMethods();

        for (Method method : methods) {
            Author annotation = method.getAnnotation(Author.class);

            if (annotation != null) {
                methodsByAuthor.putIfAbsent(annotation.name(),
                        new ArrayList<>());
                methodsByAuthor.get(annotation.name())
                        .add(method.getName() + "()");
            }
        }

        for (Map.Entry<String, List<String>> stringListEntry : methodsByAuthor.entrySet()) {
            System.out.printf("%s: %s%n",
                    stringListEntry.getKey(),
                    String.join(", ",
                            stringListEntry.getValue()));
        }
    }

    @Author(name = "Pesho")
    public static void main(String[] args) {
        Tracker.printMethodsByAuthor(Tracker.class);
    }
}