package _06CustomEnumAnnotations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 18.7.2018 г.
 * Time: 12:34 ч.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(System.in));

        String className = bufferedReader.readLine();

        if ("Rank".equals(className)) {
            Class<CardRank> rankTypeClass = CardRank.class;
            printCustomEnumAnnotation(rankTypeClass);
        } else if ("Suit".equals(className)) {
            Class<CardSuit> suitTypeClass = CardSuit.class;
            printCustomEnumAnnotation(suitTypeClass);
        }
    }

    private static void printCustomEnumAnnotation(Class<?> clazz) {
        if (clazz.isAnnotationPresent(Annotation.class)) {
            Annotation annotation = clazz.getAnnotation(Annotation.class);
            System.out.println(String.format("Type = %s, Description = %s",
                    annotation.type(),
                    annotation.description()));
        }
    }
}