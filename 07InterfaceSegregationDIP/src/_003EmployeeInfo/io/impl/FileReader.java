package _003EmployeeInfo.io.impl;


import _003EmployeeInfo.io.interfaces.Reader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 2.8.2018 г.
 * Time: 14:23 ч.
 */
public class FileReader implements Reader {

    private static final String DEFAULT_FILE_NAME = "input";
    private static final String DEFAULT_FILE_PATH = System.getProperty("user.dir")
            + "/src/resources/" + DEFAULT_FILE_NAME;

    @Override
    public String readLine() {
        StringBuilder fileContent = new StringBuilder();

        try (
                InputStream inputStream = getClass()
                        .getResourceAsStream(DEFAULT_FILE_PATH);
                BufferedReader bufferedReader =
                        new BufferedReader(
                                new InputStreamReader(inputStream))
        ) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                fileContent.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return fileContent.toString();
    }
}