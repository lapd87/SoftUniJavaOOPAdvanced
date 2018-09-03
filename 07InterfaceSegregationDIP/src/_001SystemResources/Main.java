package _001SystemResources;

import _001SystemResources.impl.GreetingClock;
import _001SystemResources.impl.LocalTimeProvider;
import _001SystemResources.interfaces.GreetingDevice;
import _001SystemResources.io.impl.ConsoleWriter;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 3.8.2018 г.
 * Time: 10:55 ч.
 */
public class Main {
    public static void main(String[] args) {

        GreetingDevice greetingClock = new GreetingClock(
                new LocalTimeProvider(), new ConsoleWriter());

        greetingClock.greeting();
    }
}