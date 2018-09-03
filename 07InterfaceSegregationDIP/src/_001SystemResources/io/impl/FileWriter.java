package _001SystemResources.io.impl;

import _001SystemResources.io.interfaces.Writer;

import java.io.*;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 2.8.2018 г.
 * Time: 14:19 ч.
 */
public class FileWriter implements Writer {

    private static final String DEFAULT_FILE_NAME = "result";
    private static final String DEFAULT_FILE_PATH = System.getProperty("user.dir")
            + "/src/resources/" + DEFAULT_FILE_NAME;


    @Override
    public void write(String line) {
        try (
                OutputStream outputStream =
                        new FileOutputStream(DEFAULT_FILE_PATH);
                BufferedWriter bufferedWriter =
                        new BufferedWriter(
                                new OutputStreamWriter(outputStream))
        ) {
            bufferedWriter.write(line);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void writeLine(String line) {
        this.write(line + System.lineSeparator());
    }
}