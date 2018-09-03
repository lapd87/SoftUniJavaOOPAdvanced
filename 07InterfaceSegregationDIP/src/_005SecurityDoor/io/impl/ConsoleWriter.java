package _005SecurityDoor.io.impl;

import _005SecurityDoor.io.interfaces.Writer;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 2.8.2018 г.
 * Time: 14:13 ч.
 */
public class ConsoleWriter implements Writer {

    @Override
    public void write(String line) {
        System.out.print(line);
    }

    @Override
    public void writeLine(String line) {
        System.out.println(line);
    }
}