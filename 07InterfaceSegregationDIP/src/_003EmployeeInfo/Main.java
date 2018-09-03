package _003EmployeeInfo;

import _002Services.io.impl.ConsoleWriter;
import _002Services.io.interfaces.Writer;
import _003EmployeeInfo.contracts.Database;
import _003EmployeeInfo.contracts.Formatter;
import _003EmployeeInfo.contracts.InfoProvider;
import _003EmployeeInfo.contracts.Runnable;
import _003EmployeeInfo.models.ConsoleClient;
import _003EmployeeInfo.models.ConsoleFormatter;
import _003EmployeeInfo.models.EmployeeDatabase;
import _003EmployeeInfo.models.EmployeeInfoProvider;

public class Main {
    public static void main(String[] args) {

        Database employeeDatabase = new EmployeeDatabase();

        InfoProvider employeeInfoProvider = new EmployeeInfoProvider(employeeDatabase);
        Writer consoleWriter = new ConsoleWriter();
        Formatter employeeConsoleFormatter = new ConsoleFormatter();

        Runnable consoleClient = new ConsoleClient(employeeInfoProvider,
                consoleWriter, employeeConsoleFormatter);

        consoleClient.run();
    }
}
