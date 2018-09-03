package _003EmployeeInfo.models;

import _003EmployeeInfo.contracts.Formatter;

public class ConsoleFormatter implements Formatter<Employee> {

    @Override
    public String format(Iterable<Employee> employees) {
        StringBuilder sb = new StringBuilder();
        for (Employee employee : employees) {
            sb.append(employee).append(System.lineSeparator());
        }

        return sb.toString();
    }
}
