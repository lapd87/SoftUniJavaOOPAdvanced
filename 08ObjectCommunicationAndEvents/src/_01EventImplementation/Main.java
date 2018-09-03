package _01EventImplementation;

import _01EventImplementation.models.Dispatcher;
import _01EventImplementation.models.Handler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 5.8.2018 г.
 * Time: 11:59 ч.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(System.in));

        Dispatcher dispatcher = new Dispatcher();
        Handler handler = new Handler();

        dispatcher.addNameChangeListener(handler);

        String name;
        while (true) {
            if ("End".equals(name = bufferedReader.readLine())) {
                break;
            }

            dispatcher.setName(name);
        }
    }
}