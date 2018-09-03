package hell.io.impl;


import hell.interfaces.OutputWriter;

import java.io.*;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 2.8.2018 г.
 * Time: 14:19 ч.
 */
public class FileWriter implements OutputWriter {

    private static final String DEFAULT_FILE_NAME = "result";
    private static final String DEFAULT_FILE_PATH = System.getProperty("user.dir")
            + "/src/resources/" + DEFAULT_FILE_NAME;


    @Override
    public void writeLine(String line) {
        try (
                OutputStream outputStream =
                        new FileOutputStream(DEFAULT_FILE_PATH);
                BufferedWriter bufferedWriter =
                        new BufferedWriter(
                                new OutputStreamWriter(outputStream))
        ) {
            bufferedWriter.write(line);
            bufferedWriter.write(System.lineSeparator());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void writeLine(String format, Object... params) {
        writeLine(String.format(format, params));
    }
}