package _003EmployeeInfo.models;

import _002Services.io.interfaces.Writer;
import _003EmployeeInfo.contracts.Formatter;
import _003EmployeeInfo.contracts.InfoProvider;
import _003EmployeeInfo.contracts.Runnable;

public class ConsoleClient implements Runnable {

    private InfoProvider<Employee> infoProvider;
    private Writer writer;
    private Formatter<Employee> formatter;

    public ConsoleClient(InfoProvider<Employee> infoProvider,
                         Writer writer, Formatter<Employee> formatter) {
        this.infoProvider = infoProvider;
        this.writer = writer;
        this.formatter = formatter;
    }

    @Override
    public void run() {
        this.writer.writeLine(this.formatter
                .format(this.infoProvider.getByName()));
    }
}
