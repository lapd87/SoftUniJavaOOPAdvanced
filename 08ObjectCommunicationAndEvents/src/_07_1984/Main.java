package _07_1984;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 5.8.2018 г.
 * Time: 18:10 ч.
 */
public class Main {
    public static void main(String[] args) throws IOException, InvocationTargetException, IllegalAccessException {
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(System.in));

        int[] mnp = Arrays.stream(bufferedReader.readLine()
                .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        List<Subject> subjects = new ArrayList<>();

        for (int i = 0; i < mnp[0]; i++) {
            String[] input = bufferedReader.readLine()
                    .split("\\s+");

            Subject subject = null;
            switch (input[0]) {
                case "Employee":
                    subject = new Employee(input[1],
                            input[2],
                            Integer.parseInt(input[3]));
                    break;
                case "Company":
                    subject = new Company(input[1],
                            input[2],
                            Integer.parseInt(input[3]),
                            Integer.parseInt(input[4]));
            }

            subjects.add(subject);
        }

        List<Observer> observers = new ArrayList<>();

        for (int i = 0; i < mnp[1]; i++) {
            String[] input = bufferedReader.readLine()
                    .split("\\s+");

            Set<Subject> subjectSet = new HashSet<>();
            for (int j = 3; j < input.length; j++) {
                int finalJ = j;
                subjects.stream()
                        .filter(s ->
                                Arrays.stream(s.getClass()
                                        .getDeclaredFields())
                                        .anyMatch(fName -> input[finalJ]
                                                .equals(fName.getName()))
                                        || Arrays.stream(s.getClass()
                                        .getSuperclass()
                                        .getDeclaredFields())
                                        .anyMatch(fName -> input[finalJ]
                                                .equals(fName.getName())))
                        .forEach(subjectSet::add);
            }

            observers.add(new Institution(input[1],
                    input[2],
                    Arrays.stream(input)
                            .skip(3)
                            .toArray(String[]::new),
                    subjectSet.toArray(new Subject[0])));
        }

        for (int i = 0; i < mnp[2]; i++) {
            String[] input = bufferedReader.readLine()
                    .split("\\s+");

            for (Subject subject : subjects) {
                if (subject.getId().equals(input[0])) {
                    Method[] methodsSuper = subject.getClass()
                            .getSuperclass()
                            .getDeclaredMethods();

                    Method[] methodsClass = subject.getClass()
                            .getDeclaredMethods();

                    List<Method> methods = new ArrayList<>();
                    methods.addAll(Arrays.asList(methodsSuper));
                    methods.addAll(Arrays.asList(methodsClass));

                    for (Method method : methods) {
                        method.setAccessible(true);

                        String methodName = method.getName()
                                .toLowerCase();

                        if (methodName.startsWith("set")
                                && methodName.endsWith(input[1].toLowerCase())) {
                            method.invoke(subject, input[2]);
                            break;
                        }
                    }
                }
            }
        }

        observers.forEach(System.out::println);
    }
}