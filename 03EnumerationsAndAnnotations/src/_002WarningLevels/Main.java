package _002WarningLevels;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 18.7.2018 г.
 * Time: 09:48 ч.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(System.in));

        String loggerImportanceLevel = bufferedReader.readLine();

        Logger logger = new Logger(loggerImportanceLevel);

        String input;
        while (true) {
            if ("END".equals(input = bufferedReader.readLine())) {
                break;
            }

            String[] messageArgs = input.split(": ");

            Message message = new Message(messageArgs[0],
                    messageArgs[1]);

            logger.addMessage(message);
        }

        for (Message message : logger.getMessages()) {
            System.out.println(message);
        }
    }
}