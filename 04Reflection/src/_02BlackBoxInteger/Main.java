package _02BlackBoxInteger;

import _02BlackBoxInteger.com.BlackBoxInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(System.in));

        try {
            Class<BlackBoxInt> aClass = BlackBoxInt.class;

            Constructor<BlackBoxInt> constructor = aClass.getDeclaredConstructor();
            constructor.setAccessible(true);

            BlackBoxInt blackBoxInt = constructor.newInstance();

            String input;
            while (true) {
                if ("END".equals(input = bufferedReader.readLine())) {
                    break;
                }

                String[] commandArgs = input.split("_");

                String methodName = commandArgs[0];

                Method method = blackBoxInt.getClass()
                        .getDeclaredMethod(methodName, int.class);
                method.setAccessible(true);
                method.invoke(blackBoxInt, Integer.parseInt(commandArgs[1]));

                Field field = blackBoxInt.getClass()
                        .getDeclaredField("innerValue");
                field.setAccessible(true);

                System.out.println(field.get(blackBoxInt));
            }
        } catch (InstantiationException
                | IllegalAccessException
                | NoSuchMethodException
                | InvocationTargetException
                | NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}
